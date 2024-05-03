import { useQuery } from "@tanstack/react-query"
import { getAllSemester } from "../../services/apiSemesters"

export const useSemester = ()=> {

    const {isLoading,data:semesters} = useQuery({
        queryKey:["semesters"],
        queryFn: getAllSemester
    })


    return {isLoading,semesters}
}