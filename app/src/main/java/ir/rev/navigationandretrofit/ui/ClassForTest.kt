package ir.rev.navigationandretrofit.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// класс для теста при передачи данных между экранами он должен иметь анатацию @Parcelize и интерфейс Parcelable
@Parcelize
data class ClassForTest(
    val text: String
) : Parcelable