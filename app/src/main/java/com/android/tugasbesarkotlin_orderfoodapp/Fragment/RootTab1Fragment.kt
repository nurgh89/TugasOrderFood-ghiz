//package com.android.tugasbesarkotlin_orderfoodapp.Fragment
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.android.tugasbesarkotlin_orderfoodapp.R
//
//class RootTab1Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private const val ARG_PARAM1 = "param1"
//    private const val ARG_PARAM2 = "param2"
//
//    /**
//     * A simple [Fragment] subclass.
//     * Use the [RootTab1Fragment.newInstance] factory method to
//     * create an instance of this fragment.
//     *
//     */
//    class RootTab1Fragment : Fragment() {
//        // TODO: Rename and change types of parameters
//        private var param1: String? = null
//        private var param2: String? = null
//        private var root1View: View? = null
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            arguments?.let {
//                param1 = it.getString(ARG_PARAM1)
//                param2 = it.getString(ARG_PARAM2)
//            }
//        }
//
//        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                                  savedInstanceState: Bundle?): View? {
//            // Inflate the layout for this fragment
//            root1View =  inflater.inflate(R.layout.activity_bar_satu, container, false)
//            activity!!.supportFragmentManager.beginTransaction().replace(R.id.bar1, RegistrationFragment()).commit()
//            return root1View
//        }
//
//
//        companion object {
//            /**
//             * Use this factory method to create a new instance of
//             * this fragment using the provided parameters.
//             *
//             * @param param1 Parameter 1.
//             * @param param2 Parameter 2.
//             * @return A new instance of fragment RootTab1Fragment.
//             */
//            // TODO: Rename and change types and number of parameters
//            @JvmStatic
//            fun newInstance(param1: String, param2: String) =
//                RootTab1Fragment().apply {
//                    arguments = Bundle().apply {
//                        putString(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
//                    }
//                }
//        }
//}