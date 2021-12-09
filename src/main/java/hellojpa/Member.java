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

    @ManyToOne(fetch = FetchType.EAGER)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getTestLocalDate() {
        return testLocalDate;
    }

    public void setTestLocalDate(LocalDateTime testLocalDate) {
        this.testLocalDate = testLocalDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
