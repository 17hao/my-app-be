package xyz.shiqihao.app.service;

import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import xyz.shiqihao.app.dao.UserDao;
import xyz.shiqihao.app.model.User;
import xyz.shiqihao.grpc.UserServiceGrpc;
import xyz.shiqihao.grpc.UserServiceProto.QueryUserRequest;
import xyz.shiqihao.grpc.UserServiceProto.QueryUserResponse;

@GrpcService
@AllArgsConstructor
public class DefaultUserServiceGrpc extends UserServiceGrpc.UserServiceImplBase {
    private final UserDao userDao;

    @Override
    public void queryUser(QueryUserRequest request, StreamObserver<QueryUserResponse> responseObserver) {
        User user = userDao.findById(request.getId());
        QueryUserResponse response = QueryUserResponse.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
