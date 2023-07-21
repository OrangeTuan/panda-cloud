//package com.example.feignclient.listener;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * rocketmq事务监听器
// * @author xiaochen
// * @date 2023-07-03 10:56
// */
//public class MyTransactionListener implements TransactionListener {
//
//    private AtomicInteger transactionIndex = new AtomicInteger(0);
//
//    /**
//     * 储存本地事务的状态，用于回查
//     */
//    private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();
//
//    /**
//     * 本地事务方法，业务逻辑
//     * @param msg
//     * @param o
//     * @return
//     */
//    @Override
//    public LocalTransactionState executeLocalTransaction(Message msg, Object o) {
//        int value = transactionIndex.getAndIncrement();
//        int status = value % 3;
//        localTrans.put(msg.getTransactionId(), status);
//        return LocalTransactionState.UNKNOW;
//    }
//
//    /**
//     * 回查事务状态的逻辑
//     * @param msg
//     * @return
//     */
//    @Override
//    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
//        Integer status = localTrans.get(msg.getTransactionId());
//        if (null != status) {
//            switch (status) {
//                case 0:
//                    return LocalTransactionState.UNKNOW;
//                case 1:
//                    return LocalTransactionState.COMMIT_MESSAGE;
//                case 2:
//                    return LocalTransactionState.ROLLBACK_MESSAGE;
//                default:
//                    return LocalTransactionState.COMMIT_MESSAGE;
//            }
//        }
//        return LocalTransactionState.COMMIT_MESSAGE;
//    }
//}
