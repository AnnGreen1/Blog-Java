package com.github.service.bill;

import com.github.dao.BaseDao;
import com.github.dao.bill.BillDao;
import com.github.dao.bill.BillDaoImpl;
import com.github.pojo.Bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Package: com.github.service.bill
 * @ClassName: BillServiceImpl
 * @Author: subei
 * @CreateTime: 2021/8/15 10:13
 * @Description:
 */
public class BillServiceImpl implements BillService {
    private BillDao billDao;
    public BillServiceImpl(){
        billDao = new BillDaoImpl();
    }

    // ���Ӷ���
    @Override
    public boolean add(Bill bill) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            // ����JDBC�������
            connection.setAutoCommit(false);
            if(billDao.add(connection,bill) > 0) {
                flag = true;
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            // ��service�����connection���ӵĹر�
            BaseDao.closeResult(connection, null, null);
        }

        return flag;
    }

    // ͨ����ѯ������ȡ��Ӧ���б�-ģ����ѯ-getBillList
    @Override
    public List<Bill> getBillList(Bill bill) {
        Connection connection = null;
        List<Bill> billList = null;
        System.out.println("query productName ---- > " + bill.getProductName());
        System.out.println("query providerId ---- > " + bill.getProviderId());
        System.out.println("query isPayment ---- > " + bill.getIsPayment());

        try {
            connection = BaseDao.getConnection();
            billList = billDao.getBillList(connection, bill);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResult(connection, null, null);
        }

        return billList;
    }

    // ͨ��delIdɾ��Bill
    @Override
    public boolean deleteBillById(String delId) {
        Connection connection = null;
        boolean flag = false;

        try {
            connection = BaseDao.getConnection();
            if(billDao.deleteBillById(connection, delId) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResult(connection, null, null);
        }

        return flag;
    }

    // ͨ��billId��ȡBill
    @Override
    public Bill getBillById(String id) {
        Bill bill = null;
        Connection connection = null;

        try{
            connection = BaseDao.getConnection();
            bill = billDao.getBillById(connection, id);
        }catch (Exception e) {
            e.printStackTrace();
            bill = null;
        }finally{
            BaseDao.closeResult(connection, null, null);
        }

        return bill;
    }

    // �޸Ķ�����Ϣ
    @Override
    public boolean modify(Bill bill) {
        Connection connection = null;
        boolean flag = false;
        
        try {
            connection = BaseDao.getConnection();
            if(billDao.modify(connection,bill) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResult(connection, null, null);
        }

        return flag;
    }

}
