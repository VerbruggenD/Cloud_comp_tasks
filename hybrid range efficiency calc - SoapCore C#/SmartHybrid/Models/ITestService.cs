using System.ServiceModel;
namespace Models
{
    [ServiceContract]
    public interface ITestService
    {
        [OperationContract]
        string Test(string s);
    }
}
