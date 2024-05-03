import { useQuery } from "@tanstack/react-query"

import { findAllExam } from "../../services/apiExams"

export const useExams = ()=> {

  const {data:exams,isLoading} = useQuery({
        queryKey: ['exams'],
        queryFn: findAllExam
    })

    return {exams,isLoading}

}