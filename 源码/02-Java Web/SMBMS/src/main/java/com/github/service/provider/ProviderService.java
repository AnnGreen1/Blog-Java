package com.github.service.provider;

import com.github.pojo.Provider;

import java.util.List;

/**
 * @Package: com.github.service.provider
 * @ClassName: ProviderService
 * @Author: subei
 * @CreateTime: 2021/8/15 9:15
 * @Description:
 */
public interface ProviderService {
    // ���ӹ�Ӧ��
    public boolean add(Provider provider);

    // ͨ����Ӧ�����ơ������ȡ��Ӧ���б�-ģ����ѯ-providerList
    public List<Provider> getProviderList(String proName, String proCode);

    // ͨ��proIdɾ��Provider
    public int deleteProviderById(String delId);

    // ͨ��proId��ȡProvider
    public Provider getProviderById(String id);

    // �޸��û���Ϣ
    public boolean modify(Provider provider);

}
