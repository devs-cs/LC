// https://leetcode.com/problems/word-ladder

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size() + 1;
        wordList.push_back(beginWord); 
        vector<vector<int>> adjList(n);
        bool found = false;
        for(int i = 0; i < n; i++)
        {
            if (wordList[i] == endWord)
                found = true;
        }
        if(!found) return 0;
        for(int i = 0; i < n; i++) //could tech do this in 26*wordLen * log(n)
        {
            for(int j = i+1; j < n; j++)
            {
                bool diff = false;
                bool edge = true;
                for(int k = 0; k < beginWord.length(); k++)
                {
                    
                    if(wordList[i][k] != wordList[j][k] && diff)
                        edge =  false;
                    else if (wordList[i][k] != wordList[j][k]) 
                        diff = true;
                }
                if(edge){
                adjList[i].push_back(j);
                adjList[j].push_back(i);
                }
            }
        }
        map<string, int> m;
        for(int i = 0; i < n; i++)
            m[wordList[i]] = i;
        queue<int> q;
        q.push(m[beginWord]);
        vector<bool> seen (n, false);
        seen[m[beginWord]] = true;
        int count = 0;
        vector<int> dist (n);
        dist[m[beginWord]] = 0;
        while(!seen[m[endWord]] && !q.empty())
        {
            
            count++;
            int pos = q.front();
            // cout << pos << endl;
            // cout << wordList[pos] << "TEST" << endl;
            q.pop();
            for(int i = 0; i < adjList[pos].size(); i++)
            {
                if(seen[adjList[pos][i]]) continue;
                q.push(adjList[pos][i]);
                dist[adjList[pos][i]] = dist[pos] + 1;
                // cout <<  wordList[adjList[pos][i]]<< endl;
                seen[adjList[pos][i]] = true;
            }
        }
        if(q.empty() && !seen[m[endWord]])
            return 0;
        return dist[m[endWord]]+1;
  
        
    }
};