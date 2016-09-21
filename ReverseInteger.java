/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
*/


// Very simple explanation
// https://discuss.leetcode.com/topic/42572/sharing-my-2ms-java-solution-with-explanation

public int reverseBits(int n) 
{
    if (n == 0) 
		return 0;
    
    int result = 0;
    for (int i = 0; i < 32; i++) 
	{
        result <<= 1;
        if ((n & 1) == 1) 
			result++;
        n >>= 1;
    }
    return result;
}