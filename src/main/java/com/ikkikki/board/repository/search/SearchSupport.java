package com.ikkikki.board.repository.search;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.stream.Stream;

public interface SearchSupport<T> {


    default Stream<OrderSpecifier<?>> getOrder(Class<T> clazz, Sort sort){
      return sort.stream().map(order -> {
        Order direction = order.isAscending() ? Order.ASC : Order.DESC;
        String prop = order.getProperty();

        Expression<T> expression = new PathBuilder<>(clazz, prop);
//        PathBuilder<T> builder = new PathBuilder<>(clazz, prop);
        // prop 이슈 발생 가능성 : 복합적인 이름을 가진 칼럼에서는 검색이 어려울수있다
        // prop 대신 toAlias 메서드 만들어서, 이슈발생가능성 제거.
        return new OrderSpecifier(direction, expression);
      });
    }

    private String toAlias(Class<T> clazz) {
      return Character.toLowerCase(clazz.getName().charAt(0)) + clazz.getName().substring(1);
      // 클래스 이름 가져와서 첫글자 자르기, 나머지를 뒤에 붙여주기
    }
}
