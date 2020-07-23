package io.github.chhabra_dhiraj.cameramusicapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import io.github.chhabra_dhiraj.cameramusicapp.R
import io.github.chhabra_dhiraj.cameramusicapp.databinding.ActivityMusicLibraryBinding
import io.github.chhabra_dhiraj.cameramusicapp.ui.fragments.SongListPageFragment

private const val NUM_PAGES = 2

class MusicLibraryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_music_library)

        binding.btnMore.setOnClickListener {
            binding.thirdRowLayout.visibility = View.VISIBLE
            binding.btnMore.text = resources.getString(R.string.btn_new_release_string)
        }

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        binding.viewpager2.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager2) { tab, position ->
            if (position == 0) {
                tab.text = "Hot Song"
            } else {
                tab.text = "My Favorites"
            }
        }.attach()
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = SongListPageFragment()
    }
}