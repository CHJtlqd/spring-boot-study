package hello.hellosping.domain;

import javax.persistence.*;

@Entity
public class Member {

    // db가 알아서 생성해주는 키 매핑
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
