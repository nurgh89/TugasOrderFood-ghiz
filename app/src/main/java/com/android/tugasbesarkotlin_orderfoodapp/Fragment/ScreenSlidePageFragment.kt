package com.android.tugasbesarkotlin_orderfoodapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.tugasbesarkotlin_orderfoodapp.R


class ScreenSlidePageFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View = inflater.inflate(R.layout.activity_slide_page_screen, container, false)
    }

