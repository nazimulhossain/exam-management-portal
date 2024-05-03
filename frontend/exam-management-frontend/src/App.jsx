import { RouterProvider, createBrowserRouter } from "react-router-dom";
import {QueryClient,QueryClientProvider} from "@tanstack/react-query";
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';
import { Toaster } from "react-hot-toast";


import AppLayout from "./ui/AppLayout";
import Dashboard from "./ui/Dashboard";
import Courses from "./pages/Courses";
import Batches from "./pages/Batches";
import CourseBatches from "./features/batches/CourseBatches";
import Semesters from "./pages/Semesters";
import CourseSemesters from "./features/semesters/CourseSemesters";
import Exam from "./pages/Exams";
import Exams from "./pages/Exams";
import CourseExam from "./features/exams/CourseExam";
import Subjects from "./pages/Subjects";
import SemesterInfo from "./features/semesters/SemesterInfo";
import CreateExam from "./features/exams/CreateExam";
import Question from "./pages/Questions";
import CreateExamQuestion from "./features/questions/CreateExamQuestion";
import CoursesList from "./features/courses/CoursesList";
import SubjectList from "./features/subjects/SubjectList";
import QuestionType from "./features/questions/QuestionType";
import McqOptions from "./features/questions/McqOptions";




  const router = createBrowserRouter([
    {
      path: "/",
      element: <AppLayout />,

      children : [
  
        {
          path: "dashboard",
          element:<Dashboard />
        },
         {
          path :"courses",
          element:<Courses />

         },
         {
          path:"batches",
          element: <Batches />
         },
         {
          path:"batches/:courseName",
          element:<CourseBatches />
          
         },
         {
          path:"semesters",
          element:<Semesters />
          
         },
         {
          path:"semesters/:courseName",
          element:<CourseSemesters />
          
         },
         {
          path:"exams",
          element:<Exams />
          
         },
         {
          path:"exams/:courseName",
          element:<CourseExam />
          
         },
         {
          path:"exams/:courseName/:id",
          element:<CreateExam />
          
         },
         {
          path:"semesters/:semesterId/courses",
          element:<CoursesList />
          
         },
         {
          path:"/semesters/:semesterId/subjects",
          element:<SubjectList />
          
         },
         {
          path:"subjects",
          element:<Subjects />
          
         },
         {
          path:"semesters/BCA/:id",
          element: <SemesterInfo />
         },
         {
          path:"questions",
          element:<Question />
          
         },
         {
          path:"questions/:examName",
          element:<QuestionType />
          
         },
         {
          path:"mcq/:id/options",
          element:<McqOptions />
          
         },
         {
          path:"questions/:examName/:questionType",
          element:<CreateExamQuestion />
          
         },


      ]
    }
  ])


const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      staleTime: 0,
    }

  }
})  

function App(){
  return(

    <QueryClientProvider client={queryClient}>
      <ReactQueryDevtools initialIsOpen={false} />


    <RouterProvider router={router} />
    <Toaster
        position="top-center"
        gutter={12}
        containerStyle={{ margin: "8px" }}
        toastOptions={{
          success: {
            duration: 3000,
          },
          error: {
            duration: 5000,
          },
          style: {
            fontSize: "16px",
            maxWidth: "500px",
            padding: "16px 24px",
            // backgroundColor: "red",
            // color: "var(--color-grey-700)",
          },
        }}
      />
    </QueryClientProvider>

  ) 
}

export default App;
