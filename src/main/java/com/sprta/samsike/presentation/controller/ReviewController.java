package com.sprta.samsike.presentation.controller;

import com.sprta.samsike.application.dto.response.ApiResponseDTO;
import com.sprta.samsike.application.dto.restaurant.ReviewDTO;
import com.sprta.samsike.application.service.ReviewService;
import com.sprta.samsike.infrastructure.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{restaruantid}")
    @Operation(summary = "레스토랑 id로 리뷰 조회", description = "")
    public ResponseEntity<ApiResponseDTO> getReview(@PathVariable("restaruantid") UUID restaruantid) {
        return ResponseEntity.ok(new ApiResponseDTO<>("success", reviewService.getReviewById(restaruantid)));
    }

    @GetMapping("/rating/{restaruantid}")
    @Operation(summary = "레스토랑 리뷰 평균 평점 조회", description = "")
    public ResponseEntity<ApiResponseDTO> getReviewRating(@PathVariable("restaruantid") UUID restaruantid) {
        return ResponseEntity.ok(new ApiResponseDTO<>("success", reviewService.getReviewRating(restaruantid)));
    }

    @PostMapping("/{orderid}")
    @Operation(summary = "리뷰 작성", description = "주문 id 넣어야 함")
    public ResponseEntity<?> createReview(
            @AuthenticationPrincipal UserDetailsImpl user,
            @PathVariable("orderid") UUID orderId,
            @RequestBody @Valid ReviewDTO reviewDTO
    ) {
        return ResponseEntity.ok(new ApiResponseDTO<>("success", reviewService.createReview(user, orderId, reviewDTO)));
    }

    @PutMapping("/{reviewid}")
    @Operation(summary = "리뷰 수정")
    public ResponseEntity<?> updateReview(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                          @PathVariable("reviewid") UUID reviewId,
                                          @RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(new ApiResponseDTO<>("success", reviewService.updateReview(userDetails, reviewId, reviewDTO)));

    }

    @DeleteMapping("/{reviewid}")
    @Operation(summary = "리뷰 삭제")
    public ResponseEntity<?> deleteReview(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                          @PathVariable("reviewid") UUID reviewId) {
        return ResponseEntity.ok(new ApiResponseDTO<>("success", reviewService.deleteReview(userDetails, reviewId)));
    }

    @GetMapping("/search")
    @Operation(summary = "리뷰 검색")
    public ResponseEntity<ApiResponseDTO> search(@RequestParam("keyword") String keyword,
                                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                                 @RequestParam(value = "sortBy", defaultValue = "createdAt") String sortBy,
                                                 @RequestParam(value = "ascending", defaultValue = "false") boolean ascending,
                                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(new ApiResponseDTO("success", reviewService.searchReview(page - 1, size, sortBy, ascending, userDetails, keyword)));
    }


}
