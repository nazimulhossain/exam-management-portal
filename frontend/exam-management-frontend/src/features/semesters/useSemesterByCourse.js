import { useQuery } from "@tanstack/react-query"
import { getAllSemesterByCoureseAPI } from "../../services/apiSemesters"

export const useSemesterByCourse = (courseName)=> {

  const {data:semestersbycourse,isLoading} = useQuery({
        queryKey: ['semestersbycourse'],
        queryFn: ()=> getAllSemesterByCoureseAPI(courseName)
    })

    return {semestersbycourse,isLoading}

}