package com.github.dao.provider;

import com.github.pojo.Provider;

import java.sql.Connection;
import java.util.List;

/**
 * @Package: com.github.dao.provider
 * @ClassName: ProviderDao
 * @Author: subei
 * @CreateTime: 2021/8/15 8:52
 * @Description: ��Ӧ�̹���ӿ�
 */
public interface ProviderDao {

    // ���ӹ�Ӧ��
    public int add(Connection connection, Provider provider)throws Exception;

    // ͨ����Ӧ�����ơ������ȡ��Ӧ���б�-ģ����ѯ-providerList
    public List<Provider> getProviderList(Connection connection, String proName, String proCode)throws Exception;

    // ͨ��proIdɾ��Provider
    public int deleteProviderById(Connection connection, String delId)throws Exception;

    // ͨ��proId��ȡProvider
    public Provider getProviderById(Connection connection, String id)throws Exception;

    // �޸��û���Ϣ
    public int modify(Connection connection, Provider provider)throws Exception;

}
