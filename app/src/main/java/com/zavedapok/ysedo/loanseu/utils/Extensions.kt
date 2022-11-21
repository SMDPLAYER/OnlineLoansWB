package com.zavedapok.ysedo.loanseu.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 * Created by Siddikov Mukhriddin on 3/30/22
 */
val Number.toPx get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this.toFloat(),
    Resources.getSystem().displayMetrics)