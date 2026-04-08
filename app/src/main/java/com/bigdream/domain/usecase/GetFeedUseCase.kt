package com.bigdream.domain.usecase

import com.bigdream.domain.model.Post
import com.bigdream.domain.repository.PostRepository
import javax.inject.Inject

class GetFeedUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke(): Result<List<Post>> {
        return postRepository.getFeed()
    }
}
