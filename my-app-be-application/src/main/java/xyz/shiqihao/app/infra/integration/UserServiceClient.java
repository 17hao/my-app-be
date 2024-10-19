package xyz.shiqihao.app.infra.integration;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import xyz.shiqihao.grpc.UserServiceGrpc;
import xyz.shiqihao.grpc.UserServiceProto;

public class UserServiceClient {
    private final ManagedChannel channel = ManagedChannelBuilder.forTarget("").build();

    public UserServiceProto.QueryUserResponse queryUser(long id) {
        UserServiceProto.QueryUserRequest request = UserServiceProto.QueryUserRequest.newBuilder().setId(id).build();
        return UserServiceGrpc.newBlockingStub(channel).queryUser(request);
    }
}
