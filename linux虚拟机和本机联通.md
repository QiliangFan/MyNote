1. 找 nat 模式的虚拟网卡，这是安装虚拟机时分配的ip 如  172.16.169.0
2.  虚拟机网络设置为nat模式，再vi /etc/sysconfig/network-scripts/ifcfg-eth0 或 ens33 （总之是eth  ens） 配置如下

![1](/home/liangliang/文档/Hadoop/1.png)

IPADDRE 为 172.16.169.*   *表示任意



随后service network restart



后面再在/etc/hosts 中修改主机映射