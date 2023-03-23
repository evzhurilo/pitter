package com.zhurilo.pitter.dto;

import lombok.*;

@Builder
/*Using the @Builder annotation eliminates the need to write boilerplate code for creating instances of the class,
which can be especially helpful for classes with many fields.
Instead, you can create instances using the generated builder object,
which provides a fluent interface for setting the values of the object's fields.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String name;


}
