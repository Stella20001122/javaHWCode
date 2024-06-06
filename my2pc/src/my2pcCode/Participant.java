package my2pcCode;

public interface Participant {
    /**
     * 准备阶段，确定是否可以提交事务。
     * @return 如果准备就绪并同意提交事务，返回true；否则返回false。
     */
    boolean prepare();

    /**
     * 提交阶段，提交事务的改变。
     */
    void commit();

    /**
     * 回滚阶段，回滚所有的改变。
     */
    void rollback();
}
