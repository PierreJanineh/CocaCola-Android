package com.pierrejanineh.cocacola.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pierrejanineh.cocacola.databinding.FragmentHomeBinding
import com.pierrejanineh.cocacola.logic.SingleAd

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adsAdapter: AdsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdsRecyclerView()
        loadItems()
    }

    private fun setupAdsRecyclerView() {
        adsAdapter = AdsAdapter(requireContext())

        binding.adsRecyclerView.apply {
            adapter = adsAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    private fun loadItems() {
        val items = listOf(
            SingleAd( "https://cdn.dribbble.com/userupload/10026606/file/original-85577401a3636fc28a7d8c4af4355299.jpg?resize=2048x2560&vertical=center", "לורם איפסום דולור סיט אמט, קונסקטורר אדיפיסינג אלית קולורס מונפרד אדנדום סילקוף, מרגשי ומרגשח. עמחליף לורם איפסום דולור סיט אמט, קונסקטורר אדיפיסינג אלית. סת אלמנקום ניסי נון ניבאה. דס איאקוליס וולופטה דיאם. וסטיבולום אט דולור, קראס אגת לקטוס וואל אאוגו וסטיבולום סוליסי טידום בעליק. ושבעגט ליבם סולגק. בראיט ולחת צורק מונחף, בגורמי מגמש. תרבנך וסתעד לכנו סתשם השמה - לתכי מורגם בורק? לתיג ישבעס.", "סחטיר בלובק. תצטנפל בלינדו למרקל אס לכימפו, דול, צוט ומעיוט - לפתיעם ברשג - ולתיעם גדדיש. קוויז דומור ליאמום בלינך רוגצה. לפמעט מוסן מנת. קולהע צופעט למרקוח איבן איף, ברומץ כלרשט מיחוצים. קלאצי לפרומי בלוף קינץ תתיח לרעח. לת צשחמי צש בליא, מנסוטו צמלח לביקו ננבי, צמוקו בלוקריה שיצמה ברורק. מוסן מנת. להאמית קרהשק סכעיט דז מא, מנכם למטכין נשואי מנורך. קונסקטורר אדיפיסינג אלית. סת אלמנקום ניסי נון ניבאה. דס איאקוליס וולופטה דיאם. וסטיבולום אט דולור, קראס אגת לקטוס וואל אאוגו וסטיבולום סוליסי טידום בעליק. קונדימנטום קורוס בליקרה, נונסטי קלובר בריקנה סטום, לפריקך תצטריק לרטי.\n"),
            SingleAd( "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSq2GjswAa3h3_44Uz-TiKXUERaPcKjq2FGxQ&s", "כותרת 2", "גוף"),
            SingleAd( "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTN8Cio9bKOUd-YUTjDdadi3QgxZ7ZgtfpvSg&s", "כותרת 3", "גוף")
        )
        adsAdapter.setItems(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}