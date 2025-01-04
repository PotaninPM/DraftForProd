package com.prod.draftforprod.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.prod.draftforprod.R
import com.prod.draftforprod.domain.repository.AuthRepository
import com.prod.draftforprod.presentation.screens.RootNavDestinations
import com.prod.draftforprod.presentation.screens.welcome.login.LoginScreen
import com.prod.draftforprod.presentation.screens.welcome.register.RegisterScreen
import com.prod.draftforprod.presentation.viewModels.AuthViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin

@Composable
fun WelcomeScreen(
    rootNavController: NavHostController,
    authRepository: AuthRepository = getKoin().get()
) {
    if (authRepository.getToken() != null) {
        rootNavController.navigate(RootNavDestinations.Home) {
            popUpTo(RootNavDestinations.Welcome) { inclusive = true }
        }
    }

    WelcomeScreenContent(rootNavController)
}

@Composable
private fun WelcomeScreenContent(rootNavController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf(R.string.sign_in, R.string.sign_up)
    val pagerState = rememberPagerState { tabs.size }

    LaunchedEffect(pagerState.currentPage) {
        selectedTab = pagerState.currentPage
    }

    Scaffold(
        topBar = {
            // пока так
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
                .padding(innerPadding)
        ) {
            Column {
                TabRow(selectedTabIndex = selectedTab) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                            text = { Text(text = stringResource(title)) }
                        )
                    }
                }

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) { page ->
                    when (page) {
                        0 -> LoginScreen(rootNavController)
                        1 -> RegisterScreen(rootNavController)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenDarkPreview() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        //WelcomeScreenContent()
    }
}

@Preview
@Composable
private fun WelcomeScreenLightPreview() {
    MaterialTheme(
        colorScheme = lightColorScheme()
    ) {
        //WelcomeScreenContent()
    }
}