using System.ServiceModel;
namespace Models
{
    [ServiceContract]
    public interface ISmartHybridContract
    {
        [OperationContract]
        Hybrid makeHybrid(float e_avg_consum_highway, float e_avg_consum_city, float e_avg_consum_country, 
                float p_avg_consum_highway, float p_avg_consum_city, float p_avg_consum_country, 
                int e_capacity, int p_capacity);

        [OperationContract]
        Energie calcEfficient(Hybrid hybrid, int rangeHighway, int rangeCity, int rangeCountry, float electricPrice, float petrolPrice);
    }
}
