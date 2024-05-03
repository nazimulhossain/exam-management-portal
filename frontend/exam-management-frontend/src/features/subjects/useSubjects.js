import { useQuery } from "@tanstack/react-query"
import { getAllSubjectsApi } from "../../services/apiSubjects"

export const useSubjects = ()=> {

  const {data: subjects, isLoading} =  useQuery({
        queryKey: ['subjects'],
        queryFn: getAllSubjectsApi
    })

    return {subjects, isLoading}
}