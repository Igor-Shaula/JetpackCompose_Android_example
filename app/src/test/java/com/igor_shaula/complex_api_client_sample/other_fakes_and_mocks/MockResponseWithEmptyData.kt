package com.igor_shaula.complex_api_client_sample.other_fakes_and_mocks

val mockResponseWithEmptyData = """
    {
      "data": [],
      "included": [],
      "meta": {
        "lat": 43.2002,
        "lng": 27.9425,
        "city": "Varna",
        "state": "03",
        "country": "BG",
        "country_code": "BG",
        "country_name": "Bulgaria",
        "total": 0,
        "total_unavailable": 0,
        "start_position": 0,
        "stop_position": 0,
        "price_max": 0,
        "price_histogram": {
          "data": [
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0
          ],
          "max_value": 50000
        },
        "vehicle_types": [
          {
            "type": "toy-hauler",
            "label": "Toy hauler",
            "style": "towable"
          },
          {
            "type": "truck-camper",
            "label": "Truck Camper",
            "style": "drivable"
          },
          {
            "type": "fifth-wheel",
            "label": "Fifth-wheel",
            "style": "towable"
          },
          {
            "type": "tow-vehicle",
            "label": "Tow Vehicle",
            "style": "drivable"
          },
          {
            "type": "c",
            "label": "Class C",
            "style": "drivable"
          },
          {
            "type": "camper-van",
            "label": "Camper van",
            "style": "drivable"
          },
          {
            "type": "folding-trailer",
            "label": "Folding trailer",
            "style": "towable"
          },
          {
            "type": "other",
            "label": "Other",
            "style": "both"
          },
          {
            "type": "trailer",
            "label": "Travel trailer",
            "style": "towable"
          },
          {
            "type": "a",
            "label": "Class A",
            "style": "drivable"
          },
          {
            "type": "b",
            "label": "Class B",
            "style": "drivable"
          }
        ],
        "locale": "en-us",
        "suggested": false,
        "experiments": {},
        "experiments_data": {},
        "request": {},
        "flexible_dates": null,
        "is_blended": false
      },
      "suggestions": null
    }
""".trimIndent()