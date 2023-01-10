namespace Models
{
    public class Dienst : ITestService
    {
        public string Test(string s)
        {
            Console.WriteLine("Test Method Executed!");
            return s + " " + s;
        }
    }
}
