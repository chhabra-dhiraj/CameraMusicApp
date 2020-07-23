package io.github.chhabra_dhiraj.cameramusicapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.chhabra_dhiraj.cameramusicapp.databinding.FragmentSongsListBinding
import io.github.chhabra_dhiraj.cameramusicapp.domain.Song
import io.github.chhabra_dhiraj.cameramusicapp.ui.adapters.SongsAdapter

class SongListPageFragment : Fragment() {

    private var _binding: FragmentSongsListBinding? = null

    //     This property is only valid between onCreateView and
//     onDestroyView.
    private val binding get() = _binding!!

    private val songsList = mutableListOf<Song>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSongsListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val songsAdapter = SongsAdapter()
        binding.rvSongs.adapter = songsAdapter

        songsList.add(Song(1, "Taki Taki", "DJ Snake (feat. Selena Gomez, Ozun...)"))
        songsList.add(Song(1, "Lost Without You", "DJ Snake (feat. Selena Gomez, Ozun...)"))
        songsList.add(Song(1, "Lucky You", "DJ Snake (feat. Selena Gomez, Ozun...)"))
        songsList.add(Song(1, "Beautiful", "DJ Snake (feat. Selena Gomez, Ozun...)"))

        songsAdapter.submitList(songsList)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
