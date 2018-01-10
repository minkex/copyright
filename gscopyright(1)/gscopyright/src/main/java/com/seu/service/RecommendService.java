package com.seu.service;

import com.seu.model.Recommendation;
import org.springframework.stereotype.Service;

/**
 * Created by SUN on 2017.12.21.
 */
@Service
public interface RecommendService {
    Recommendation getRecommendation();
}
