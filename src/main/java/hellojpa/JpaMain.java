package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // Persistence에서 시작
        // persistenceUnitName은 persistence.xml 에 설정되어 있음.
        //EntityManagerFactory 딱 한번만 생성, 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //EntityManager 스레드 간 공유 X, 사용하고 버린다.
        EntityManager em = emf.createEntityManager();

        //트랜잭션 필요, JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        try{
            //저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member);

            //조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getName() = " + findMember.getName());
//            System.out.println("findMember.getId() = " + findMember.getId());

            //수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            //쿼리 생성 JPQL , 객체를 대상으로 쿼리 생성
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for(Member member : result){
                System.out.println("member.getName() = " + member.getName());
            }

            tx.commit();

        }catch (Exception e) {
            tx.rollback();
        } finally {
            // 꼭 닫아야함.
            em.close();
        }

        emf.close();


    }
}
