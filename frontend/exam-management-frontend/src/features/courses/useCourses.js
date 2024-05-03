import { useQuery } from "@tanstack/react-query";
import { getAllCourses } from "../../services/apiCourses";

export function useCourses(){

    const {isLoading,data:courses} = useQuery({
        queryKey:["courses"],
        queryFn: getAllCourses
    })


    return {isLoading,courses}

}