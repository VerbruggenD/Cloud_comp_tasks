package be.smarthome;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: smart_home_power.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PowerManagementServiceGrpc {

  private PowerManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "be.smarthome.PowerManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<be.smarthome.SolarProduction,
      be.smarthome.PowerConsumer> getNewSolarProductionValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newSolarProductionValue",
      requestType = be.smarthome.SolarProduction.class,
      responseType = be.smarthome.PowerConsumer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<be.smarthome.SolarProduction,
      be.smarthome.PowerConsumer> getNewSolarProductionValueMethod() {
    io.grpc.MethodDescriptor<be.smarthome.SolarProduction, be.smarthome.PowerConsumer> getNewSolarProductionValueMethod;
    if ((getNewSolarProductionValueMethod = PowerManagementServiceGrpc.getNewSolarProductionValueMethod) == null) {
      synchronized (PowerManagementServiceGrpc.class) {
        if ((getNewSolarProductionValueMethod = PowerManagementServiceGrpc.getNewSolarProductionValueMethod) == null) {
          PowerManagementServiceGrpc.getNewSolarProductionValueMethod = getNewSolarProductionValueMethod =
              io.grpc.MethodDescriptor.<be.smarthome.SolarProduction, be.smarthome.PowerConsumer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "newSolarProductionValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.smarthome.SolarProduction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.smarthome.PowerConsumer.getDefaultInstance()))
              .setSchemaDescriptor(new PowerManagementServiceMethodDescriptorSupplier("newSolarProductionValue"))
              .build();
        }
      }
    }
    return getNewSolarProductionValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<be.smarthome.PowerConsumption,
      be.smarthome.PowerConsumer> getNewPowerConsumptionValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newPowerConsumptionValue",
      requestType = be.smarthome.PowerConsumption.class,
      responseType = be.smarthome.PowerConsumer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<be.smarthome.PowerConsumption,
      be.smarthome.PowerConsumer> getNewPowerConsumptionValueMethod() {
    io.grpc.MethodDescriptor<be.smarthome.PowerConsumption, be.smarthome.PowerConsumer> getNewPowerConsumptionValueMethod;
    if ((getNewPowerConsumptionValueMethod = PowerManagementServiceGrpc.getNewPowerConsumptionValueMethod) == null) {
      synchronized (PowerManagementServiceGrpc.class) {
        if ((getNewPowerConsumptionValueMethod = PowerManagementServiceGrpc.getNewPowerConsumptionValueMethod) == null) {
          PowerManagementServiceGrpc.getNewPowerConsumptionValueMethod = getNewPowerConsumptionValueMethod =
              io.grpc.MethodDescriptor.<be.smarthome.PowerConsumption, be.smarthome.PowerConsumer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "newPowerConsumptionValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.smarthome.PowerConsumption.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.smarthome.PowerConsumer.getDefaultInstance()))
              .setSchemaDescriptor(new PowerManagementServiceMethodDescriptorSupplier("newPowerConsumptionValue"))
              .build();
        }
      }
    }
    return getNewPowerConsumptionValueMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PowerManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PowerManagementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PowerManagementServiceStub>() {
        @java.lang.Override
        public PowerManagementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PowerManagementServiceStub(channel, callOptions);
        }
      };
    return PowerManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PowerManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PowerManagementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PowerManagementServiceBlockingStub>() {
        @java.lang.Override
        public PowerManagementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PowerManagementServiceBlockingStub(channel, callOptions);
        }
      };
    return PowerManagementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PowerManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PowerManagementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PowerManagementServiceFutureStub>() {
        @java.lang.Override
        public PowerManagementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PowerManagementServiceFutureStub(channel, callOptions);
        }
      };
    return PowerManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PowerManagementServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void newSolarProductionValue(be.smarthome.SolarProduction request,
        io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNewSolarProductionValueMethod(), responseObserver);
    }

    /**
     */
    public void newPowerConsumptionValue(be.smarthome.PowerConsumption request,
        io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNewPowerConsumptionValueMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNewSolarProductionValueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                be.smarthome.SolarProduction,
                be.smarthome.PowerConsumer>(
                  this, METHODID_NEW_SOLAR_PRODUCTION_VALUE)))
          .addMethod(
            getNewPowerConsumptionValueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                be.smarthome.PowerConsumption,
                be.smarthome.PowerConsumer>(
                  this, METHODID_NEW_POWER_CONSUMPTION_VALUE)))
          .build();
    }
  }

  /**
   */
  public static final class PowerManagementServiceStub extends io.grpc.stub.AbstractAsyncStub<PowerManagementServiceStub> {
    private PowerManagementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PowerManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PowerManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void newSolarProductionValue(be.smarthome.SolarProduction request,
        io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNewSolarProductionValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void newPowerConsumptionValue(be.smarthome.PowerConsumption request,
        io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNewPowerConsumptionValueMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PowerManagementServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PowerManagementServiceBlockingStub> {
    private PowerManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PowerManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PowerManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public be.smarthome.PowerConsumer newSolarProductionValue(be.smarthome.SolarProduction request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNewSolarProductionValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public be.smarthome.PowerConsumer newPowerConsumptionValue(be.smarthome.PowerConsumption request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNewPowerConsumptionValueMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PowerManagementServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PowerManagementServiceFutureStub> {
    private PowerManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PowerManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PowerManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.smarthome.PowerConsumer> newSolarProductionValue(
        be.smarthome.SolarProduction request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNewSolarProductionValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.smarthome.PowerConsumer> newPowerConsumptionValue(
        be.smarthome.PowerConsumption request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNewPowerConsumptionValueMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NEW_SOLAR_PRODUCTION_VALUE = 0;
  private static final int METHODID_NEW_POWER_CONSUMPTION_VALUE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PowerManagementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PowerManagementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_SOLAR_PRODUCTION_VALUE:
          serviceImpl.newSolarProductionValue((be.smarthome.SolarProduction) request,
              (io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer>) responseObserver);
          break;
        case METHODID_NEW_POWER_CONSUMPTION_VALUE:
          serviceImpl.newPowerConsumptionValue((be.smarthome.PowerConsumption) request,
              (io.grpc.stub.StreamObserver<be.smarthome.PowerConsumer>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PowerManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PowerManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return be.smarthome.SmartHomePower.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PowerManagementService");
    }
  }

  private static final class PowerManagementServiceFileDescriptorSupplier
      extends PowerManagementServiceBaseDescriptorSupplier {
    PowerManagementServiceFileDescriptorSupplier() {}
  }

  private static final class PowerManagementServiceMethodDescriptorSupplier
      extends PowerManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PowerManagementServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PowerManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PowerManagementServiceFileDescriptorSupplier())
              .addMethod(getNewSolarProductionValueMethod())
              .addMethod(getNewPowerConsumptionValueMethod())
              .build();
        }
      }
    }
    return result;
  }
}
