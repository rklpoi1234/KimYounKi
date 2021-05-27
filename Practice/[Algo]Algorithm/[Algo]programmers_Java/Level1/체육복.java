class Solution 
{

    public int solution(int n, int[] lost, int[] reserve) 
    {
		int answer = 0;
        
		int[] sArr = new int[n]; 
		
		for(int i=0 ; i < n ; i++) 
    {
			sArr[i] = 1; //체육복수 1개로 초기설정
		}
		
		for(int i : lost) 
    {
			sArr[i-1] -= 1;
		}
		
		
		for(int i : reserve) 
    {
			sArr[i-1] += 1; 
		}
		
		for(int i=0 ; i < n ; i++) 
    {
			if(sArr[i] > 0) answer++;
			if(sArr[i]==0) 
      {
				if(i>0 && sArr[i-1] == 2) 
        { 
					sArr[i-1] -= 1;
					answer++;
				}
        else if(i<n-1 && sArr[i+1] == 2)
        {
					sArr[i+1]-= 1;
					answer++;	
				}
			}
		}
		
        return answer;
	}
}
