package com.example.daznapp.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daznapp.databinding.FragmentEventsBinding
import com.example.daznapp.ui.VideoPlayerActivity
import com.example.daznapp.ui.adapter.EventsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsFragment : Fragment() {

    private var _binding: FragmentEventsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: EventsViewModel by viewModel()

    private val eventsAdapter = EventsAdapter {
        it.videoUrl?.let { url ->
            val intent = VideoPlayerActivity.getIntent(requireContext(), url)
            startActivity(intent)
        } ?: Toast.makeText(requireContext(), "No video found", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.eventList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = eventsAdapter
        }
        viewModel.events.observe(viewLifecycleOwner) {
            eventsAdapter.submitList(it)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}