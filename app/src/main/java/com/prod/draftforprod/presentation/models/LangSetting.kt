package com.prod.draftforprod.presentation.models

import androidx.annotation.StringRes
import com.prod.draftforprod.R

enum class LangSetting(
    @StringRes override val text: Int,
    val locale: String?
) : SettingEnum {
    RU(R.string.settings__lang_ru, "ru"),
    EN(R.string.settings__lang_en, "en"),
    SYSTEM(R.string.settings__lang_system, null)
}