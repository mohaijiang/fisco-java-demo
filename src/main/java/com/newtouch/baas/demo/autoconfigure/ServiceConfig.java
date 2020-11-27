package com.newtouch.baas.demo.autoconfigure;

import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.channel.handler.GroupChannelConnectionsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "channel-service")
public class ServiceConfig {

    private String agencyName;
    private int groupId;
    private static final Logger log = LoggerFactory.getLogger(ServiceConfig.class);

    @Bean
    public Service getService(GroupChannelConnectionsConfig groupChannelConnectionsConfig) {
        System.setProperty("jdk.tls.namedGroups","secp256k1");
        Service channelService = new Service();
        channelService.setConnectSeconds(30);
        channelService.setOrgID(agencyName);
        log.info("agencyName : {}", agencyName);
        channelService.setConnectSleepPerMillis(1);
        channelService.setGroupId(groupId);
        channelService.setAllChannelConnections(groupChannelConnectionsConfig);
        return channelService;
    }

    /** @return the agencyName */
    public String getAgencyName() {
        return agencyName;
    }

    /** @param agencyName the agencyName to set */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /** @return the groupId */
    public int getGroupId() {
        return groupId;
    }

    /** @param groupId the groupId to set */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}