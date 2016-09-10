package io.frontierrobotics.pathfinder.motion

import com.github.kittinunf.fuel.httpGet

fun main(args: Array<String>)
{
    "http://gturnquist-quoters.cfapps.io/api/random".httpGet().responseString { request, response, result ->
        val (data, error) = result
        if (error == null)
        {
            //do something when success
            print(data)
        } else
        {
            //error handling
        }
    }
}