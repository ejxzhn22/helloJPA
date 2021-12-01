package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "name")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

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
