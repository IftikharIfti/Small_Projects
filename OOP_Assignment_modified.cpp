#include<iostream>
#include<string>
#include<algorithm>
#include<fstream>
#include<sstream>
using namespace std;

class StudentInfo
{
 private:
 int studentID;
 string name;
 float onlineMarks[5];
 public:
 StudentInfo()
 {
    //onlineMarks=new float[5];
  for(int i=0;i<5;i++) onlineMarks[i]=0;
 }
 StudentInfo(int s,string n)
 {
    studentID=s;
    name=n;
 }
 StudentInfo(int s,string n,float *onlinemarks)
 {
  studentID=s;
  name=n;
  //onlineMarks=new float[5];
  for(int i=0;i<5;i++)
  {
    onlineMarks[i]=onlinemarks[i];
  }
 }
 ~StudentInfo()
 {
  //  cout<<"Destructor is called";
 }
 int bestThreeOnlineMarks()
 {
     sort(onlineMarks,onlineMarks+5);
   //   cout<<"Best mark: "<<onlineMarks[0]<<endl;
   //   cout<<"Second best mark: "<<onlineMarks[1]<<endl;
   //   cout<<"Third best mark: "<<onlineMarks[2]<<endl;
    int sum=onlineMarks[0]+onlineMarks[1]+onlineMarks[2];
    return sum;
 }
 void printStudentInfo()
 {
    cout<<"Student ID: "<<studentID<<endl;
    cout<<"Name: "<<name<<endl;
    for(int i=0;i<5;i++)
    {
       cout<<"Marks"<< i<<' '<<onlineMarks[i]<<endl;
    }
 }
 string getName()const
 {
   return name; 
 }
 
 int get_marks(int n)
 {
   return onlineMarks[n];
 }
};
int calculateTotalMarks(StudentInfo &student,int n)
{
   int calc=0;
   for(int i=0;i<n;i++)
   {
      calc+=student.get_marks(i);
   }
   return calc;
}
int calculateTotalMarks(StudentInfo &student)
{
   int calc=0;
   for(int i=0;i<5;i++)
   {
      calc+=student.get_marks(i);
   }
   return calc;
}
StudentInfo getBetterStudent( StudentInfo& st1, StudentInfo& st2)
{
   float calc1=0,calc2=0;
   for(int i=0;i<5;i++){
     calc1+=st1.get_marks(i);
     calc2+=st2.get_marks(i);
   }
    if(calc1>calc2)
    {
      return st1;
    }
    else 
    return st2;
}
void printRanking(StudentInfo* arr1)
{
   
   for(int i=0;i<9;i++)
   {
      for(int j=0;j<9;j++)
      {
         if(arr1[j].bestThreeOnlineMarks()>arr1[i].bestThreeOnlineMarks())
         swap(arr1[i],arr1[j]);
      }
   }
   cout<<"Ranking:";
    for (int i = 0; i < 6; i++) {
        cout << i + 1 << ". ";
        cout<<arr1[i].getName();
        cout << endl;
    }
}
int main()
{
    StudentInfo st[10];
    ifstream inputFile("data.txt");
    if(!inputFile)
    {
        cerr<<"Error!file couldn't open"<<endl;
        
    }
    string line;
    int id;
    string name;
    float marks[5];
    for(int i=0;i<10&&getline(inputFile,line);i++)
    {
        stringstream ss(line);
        ss>>id>>name;
        for(int j=0;j<5&&ss>>marks[j];j++)
        {
            //values are being read
        }
        st[i]=StudentInfo(id,name,marks);
        //st[i]=StudentInfo(id,name);//for two parameters constructor
    }
    inputFile.close();
   st[0].printStudentInfo();
   StudentInfo s=getBetterStudent(st[0],st[1]);
   cout<<"The best is:";
   s.printStudentInfo();
   printRanking(st);
}
