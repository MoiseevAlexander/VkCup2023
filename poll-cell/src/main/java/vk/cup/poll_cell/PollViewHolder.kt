package vk.cup.poll_cell

import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.allViews
import androidx.core.view.isVisible
import vk.cup.core_recycler.Cell
import vk.cup.core_recycler.DzenViewHolder
import vk.cup.poll_cell.databinding.PollItemBinding
import vk.cup.poll_cell.databinding.PollVariantBinding

class PollViewHolder(private val binding: PollItemBinding) : DzenViewHolder(binding) {

    override fun bind(item: Cell) {
        val pollCell = item as PollCellUiModel
        pollCell.answerOptionsList.forEach { pollModel ->
            val newVariant = PollVariantBinding.inflate(LayoutInflater.from(binding.root.context))
            newVariant.pollVariantText.text = pollModel.text
            val newLayoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            newLayoutParams.setMargins(30, 10, 30, 10)
            newVariant.root.layoutParams = newLayoutParams
            newVariant.root.setOnClickListener {
                newVariant.isCorrectIcon.setImageResource(
                    if (pollModel.isCorrect) R.drawable.ic_correct else R.drawable.ic_incorrect
                )
                it.startAnimation(
                    AnimationUtils.loadAnimation(binding.root.context, R.anim.anim)
                )
                it.postOnAnimation {
                    it.background =
                        if (pollModel.isCorrect) AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.poll_correct_variant_background
                        ) else AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.poll_incorrect_variant_background
                        )
                    binding.root.allViews.forEach { it ->
                        it.isClickable = false
                        it.isVisible = true
                    }
                }
            }
            newVariant.responseRate.text = pollModel.responseRate
            binding.root.addView(newVariant.root)
        }
        binding.quectionText.text = pollCell.questionText
        binding.quectionNumber.text = pollCell.questionNumber
    }

}
