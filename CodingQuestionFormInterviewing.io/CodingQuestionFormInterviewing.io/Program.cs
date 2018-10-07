using System;
using System.Linq;

namespace CodingQuestionFormInterviewing.io
{
   /// <summary>
   /// There were two task given for 25 minutes time.
   /// 1) Find the sum of the element of the array
   /// 2) Find the unique number of candy that a can eat after giving half of the total candy to B
   /// </summary>
   class Program
    {
        static void Main(string[] args)
        {
            Program program = new Program();

            //The sum of the element of the array
            int[] inputArray = { -1, -2, 3, 4, 6 };  //Ans should be 10
            var sum = program.Sum(inputArray);
            Console.WriteLine("Toal sum is : " + sum);


            //The unique number of candy that A can eat
            int[] firstCandyArray = {2,3,7,7,7,7,7,8,8,8,8,3,3,3,3,2,2,2,2,2}; //Ans should be 4
            var firstDistinctCandy = program.UniqueNumberOfCandy(firstCandyArray);
            Console.WriteLine("Toal number of unique candy is : " + firstDistinctCandy);

            int[] sencondCandyArray = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 2, 2, 2, 3, 3 }; //Ans should be 7
            var sencondDistinctCandy = program.UniqueNumberOfCandy(sencondCandyArray);
            Console.WriteLine("Toal number of unique candy is : " + sencondDistinctCandy);

            int[] thirdCandyArray = { 2, 3, 2, 2, 2, 3, 3, 3, 2, 2, 2, 3 }; //Ans should be 2
            var thirdDistinctCandy = program.UniqueNumberOfCandy(thirdCandyArray);
            Console.WriteLine("Toal number of unique candy is : " + thirdDistinctCandy);

            Console.ReadLine();
        }

        /// <summary>
        /// It gives the total sum of the element containing by the array
        /// </summary>
        /// <param name="T"></param>
        /// <returns></returns>
        public int Sum(int[] givenArray)
        {
            var ans = 0;
            for(int i= 0; i < givenArray.Length; i++)
            {
                ans += i;
            }
            return ans;
        }

        /// <summary>
        /// Gets unique number of candies
        /// </summary>
        /// <param name="candies"></param>
        /// <returns></returns>
        public int UniqueNumberOfCandy(int[] candies)
        {
            var distinctCandies = candies.Distinct();
            var lengthOfDistinct = distinctCandies.Count();

            var totalCandies = candies.Count();
            var halfOfTotalCandies = totalCandies / 2;

            if(halfOfTotalCandies == lengthOfDistinct || halfOfTotalCandies < lengthOfDistinct)
            {
                return halfOfTotalCandies;
            }
            else
            {
                return lengthOfDistinct;

            }
        }
    }
}
