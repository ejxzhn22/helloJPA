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
//            //저장 //비영속
//            Member member = new Member();
//            member.setId(10L);
//            member.setName("Helloooo");
//
//           //영속 // INSERT쿼리는 commit할 때 보내진다
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            Member findMember = em.find(Member.class, 10L);

            // 1차캐시를 통해 조회 하기 떄문에 select쿼리가 나가지 않음.
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());


            //조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getName() = " + findMember.getName());
//            System.out.println("findMember.getId() = " + findMember.getId());

              // select 쿼리는 1번만 나간다. => 2번째 부터는 1차캐시에서 가져옴
//            Member findMember1 = em.find(Member.class, 10L);
//            Member findMember2 = em.find(Member.class, 10L);

//            // 영속성 엔티티의 동일성 보장
//            System.out.println("result = " + (findMember1 == findMember2));


            //수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            //쿼리 생성 JPQL , 객체를 대상으로 쿼리 생성
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println("member.getName() = " + member.getName());
//            }


            // 쓰기지연 => commit 시점에 insert 쿼리가 나간다.
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
