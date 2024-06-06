package my2pcCode;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private final List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void executeTransaction() {
        System.out.println("Transaction started.");

        // 第一阶段：准备阶段--只要有一个没准备好，就返回false，触发回滚
        boolean allPrepared = true;
        for (Participant participant : participants) {
            if (!participant.prepare()) {
                allPrepared = false;
                break;
            }
        }

        // 第二阶段：提交或回滚阶段
        if (allPrepared) {
            System.out.println("All participants are prepared. Committing transaction.");
            for (Participant participant : participants) {
                participant.commit();
            }
            System.out.println("Transaction committed.");
        } else {
            System.out.println("Some participants are not prepared. Rolling back transaction.");
            for (Participant participant : participants) {
                participant.rollback();
            }
            System.out.println("Transaction rolled back.");
        }
    }
}
