package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    //ENUM 사용
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜 , 시간, 날짜시간 구분
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private LocalDateTime testLocalDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 큰 컨텐츠
    @Lob
    private String description;


    public Member() {
    }


}
