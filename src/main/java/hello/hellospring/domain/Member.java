package hello.hellospring.domain;

import javax.persistence.*;

// jpa가 관리하는 entity 선언
@Entity
public class Member {

    // db 에서 id 자동생성
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
