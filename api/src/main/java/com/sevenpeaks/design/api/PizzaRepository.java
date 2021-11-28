package com.sevenpeaks.design.api;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created on: 11/28/21.
 *
 * @author Bjorn Harvold
 * Responsibility:
 */
public interface PizzaRepository extends PagingAndSortingRepository<Pizza, String> {
}
