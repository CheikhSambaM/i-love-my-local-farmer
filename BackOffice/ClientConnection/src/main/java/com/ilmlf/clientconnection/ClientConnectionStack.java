package com.ilmlf.clientconnection;


import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;

import software.amazon.awscdk.services.ec2.IVpc;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcLookupOptions;

import java.util.List;

public class ClientConnectionStack extends Stack {

    public ClientConnectionStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        String vpcId = this.getNode().tryGetContext("vpcId").toString();
        String domainName = this.getNode().tryGetContext("domain").toString();
        Object dnsIps = this.getNode().tryGetContext("dns");

        VpcLookupOptions vpcLookupOptions = new VpcLookupOptions.Builder()
                .vpcId(vpcId)
                .build();

        IVpc vpc = Vpc.fromLookup(this, "Vpc", vpcLookupOptions );

        new ClientVpnConstruct(this, "ClientVpn", ClientVpnConstruct.ClientVpnProps.builder()
                .vpc(vpc)
                .domainName(domainName)
                .dnsIps((List<String>) dnsIps)
                .build());

    }
}
