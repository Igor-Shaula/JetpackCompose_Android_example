package com.igor_shaula.outdoorsy_android_challenge_task.data.local

import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel

class FakeDataSource {

    companion object {

        // temporary here - later the data will be moved on its own layer
        val fakeVehiclesList = listOf(
            VehicleModel("image-address-1", "name-1"),
            VehicleModel("image-address-2", "name-2"),
            VehicleModel("image-address-3", "name-3"),
            VehicleModel("image-address-4", "name-4"),
            VehicleModel("image-address-5", "name-5"),
            VehicleModel("image-address-6", "name-6"),
            VehicleModel("image-address-7", "name-7"),
            VehicleModel("image-address-8", "name-8"),
            VehicleModel("image-address-9", "name-9"),
            VehicleModel("image-address-0", "name-0")
        )

        val mockResponse: String = """
{
  "data": [
    {
      "id": "357873",
      "type": "rentals",
      "attributes": {
        "Explanation": null,
        "FeaturesMap": null,
        "active_options": {
          "cancel_policy": "flexible",
          "cancel_policy_combo_bookings": "",
          "date": "2024-02-09",
          "instant_book": false,
          "minimum_days": 2,
          "monthly_discount_percentage": 21,
          "monthly_rate_per_day": 10191,
          "price_per_day": 12900,
          "price_per_month": 285348,
          "price_per_week": 81270,
          "tax": 0,
          "use_day_pricing": false,
          "use_tax_inclusive_pricing": false,
          "weekly_discount_percentage": 10,
          "weekly_rate_per_day": 11610
        },
        "availability_set": false,
        "average_ratings": null,
        "average_reviews": null,
        "campground": null,
        "campground_catalog": null,
        "campsite_category": null,
        "campsite_category_catalog": null,
        "cancel_policy": "flexible",
        "cancel_policy_combo_bookings": "",
        "cancel_text": "",
        "catalog": null,
        "check_in": 0,
        "check_out": 0,
        "children_count": 0,
        "coachnet_ready": true,
        "coachnet_required": false,
        "combined_special_hours": [],
        "created": "0001-01-01T00:00:00Z",
        "current_location_id": 0,
        "custom_insurance_text": "",
        "dealer": false,
        "delivery": true,
        "delivery_radius": 90,
        "delivery_usage_item_id": 450590,
        "deposit_percentage": 0,
        "description": "",
        "description_included": "Fresh linens, towels, pot and pan, kitchen tools. Tools for water & sewer, power and for stabilization, toilet paper",
        "description_other": "No smoking in camper, make sure slide and awning are pulled in before moving.  Please be respectful and leave camper as clean as it was handed over to you.",
        "description_recommendations": "",
        "display_vehicle_type": "Travel trailer",
        "distributed_ratings": null,
        "education": [],
        "external": false,
        "favorite": false,
        "favorite_count": 24,
        "features": {
          "air_conditioner": true,
          "audio_inputs": true,
          "awning": true,
          "backup_camera": false,
          "beds_bunk": null,
          "beds_dinette_conversion": null,
          "beds_fold_out_sofa": null,
          "beds_full": 0,
          "beds_king": 0,
          "beds_other": null,
          "beds_queen": 1,
          "beds_twin": 0,
          "bike_rack": false,
          "brake_controller": false,
          "burning_man_friendly": true,
          "cd_player": true,
          "ceiling_fan": false,
          "connector_type": "7pin",
          "dining_table": true,
          "extra_storage": true,
          "festival_friendly": false,
          "generator": false,
          "gray_tank": 0,
          "handicap_accessible": false,
          "heater": true,
          "hitch_weight": 702,
          "hookup_electric": false,
          "hookup_sewer": false,
          "hookup_water": false,
          "hot_water_tank": false,
          "inside_shower": true,
          "international_travel_allowed": false,
          "inverter": false,
          "kitchen_sink": true,
          "leveling_jacks": true,
          "microwave": true,
          "minimum_age": 0,
          "mpg": 0,
          "one_way_rentals": false,
          "outside_shower": false,
          "oven": true,
          "pet_friendly": true,
          "propane_tank": 40,
          "provides_receivers": false,
          "radio": true,
          "refrigerator": true,
          "satellite": false,
          "sewage_tank": 0,
          "skylight": true,
          "slide_outs": 1,
          "smoking_allowed": false,
          "solar": false,
          "stove": true,
          "tailgate_friendly": true,
          "toilet": true,
          "tow_hitch": false,
          "trailer_weight": 4465,
          "tv_dvd": true,
          "washer_dryer": false,
          "water_tank": 40,
          "wifi": false
        },
        "first_published": "2023-05-02T20:19:40.545886-07:00",
        "generator_usage_item_id": 0,
        "group_on_map": false,
        "group_reviews_num": 0,
        "group_reviews_score": 0,
        "group_score": 0,
        "has_been_published": true,
        "has_checkout_questions": false,
        "hidden": false,
        "host_notes": "",
        "house_rules": "",
        "instant_book": false,
        "instant_book_leeway": 2,
        "insurance_coverage": "",
        "insurance_eligible": true,
        "insurance_plan": {
          "id": 97,
          "label": "Outdoorsy Towable Protection",
          "renter_body": "",
          "renter_headline": "",
          "requires_driver_verification": false
        },
        "insurance_renter_adjustable": false,
        "insurance_state": "approved",
        "last_published": "2023-05-02T20:19:40.545847-07:00",
        "listing_questions": [],
        "locale": {
          "base_currency": "USD",
          "distance_unit": "miles",
          "length_unit": "feet",
          "liquid_unit": "gallons",
          "weight_unit": "lbs"
        },
        "location": {
          "city": "Ridgewood",
          "country": "US",
          "county": "",
          "lat": 40.977,
          "lng": -74.124,
          "state": "NJ",
          "street": "16 Ethelbert Pl",
          "zip": "07450"
        },
        "mileage_usage_item_id": 450591,
        "minimum_days": 0,
        "minimum_deposit": 0,
        "misc": null,
        "monthly_discount": 2100,
        "name": "2017 Coleman 2605 Light",
        "nearby_content": [],
        "original_url": "",
        "owner_score": 0,
        "parent_id": 0,
        "position": 0,
        "preferred_primary_image": {
          "amenity": null,
          "best": false,
          "category": null,
          "description": "",
          "position": 0,
          "primary": false,
          "rental_id": 0,
          "review": null,
          "skip_enhance": false,
          "status": "",
          "tags": "",
          "url": "",
          "video": false
        },
        "prep_fee": {
          "amount": 10000,
          "description": "This fee will cover preparing , cleaning, and sanitizing the unit prior to each rental."
        },
        "presentment_currency": "USD",
        "price_per_day": 12900,
        "price_per_month": 313470,
        "price_per_week": 77400,
        "primary_image_url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083626/p/rentals/357873/images/o6bnrvbfykhsqz658yru.jpg",
        "pro": false,
        "published": true,
        "ranking": {
          "distance_weight": {
            "control": 0.35,
            "test_1": 0.6,
            "test_2": 0.35,
            "test_3": 0.35
          },
          "distance_weight_prod": 0.35,
          "is_new_listing": 0,
          "model_name": "model_gbt_web_072522",
          "original_score": 0,
          "ranking_score": 0.2257,
          "ranking_score2": 0.4392,
          "ranking_score3": 0.2257
        },
        "rental_category": "rv",
        "rental_score": 0,
        "request_less_than_minimum_days": 0,
        "review_scores": null,
        "reviews_num": 0,
        "score": 0,
        "seatbelts": 0,
        "security_deposit": 50000,
        "seo_content": {
          "category": [
            {
              "id": 199668,
              "title": "Coleman RV rental by model",
              "url": "https://www.outdoorsy.com/rv-makes-types/coleman-m"
            },
            {
              "id": 199873,
              "title": "Coleman Other RV rental (2)",
              "url": "https://www.outdoorsy.com/rv-makes-types/coleman-m/other-2"
            }
          ]
        },
        "settlement_currency": "USD",
        "sleeps": 4,
        "sleeps_adults": 0,
        "sleeps_kids": 0,
        "slug": "/rv-rental/ridgewood_nj/2017_coleman_2605-light_357873-listing",
        "smart_photo_score": 0,
        "sort_score": 3.0776982,
        "stay": null,
        "stay_catalog": null,
        "summary": "",
        "tags": [],
        "tax_rates": [],
        "type": "trailer",
        "unavailable": false,
        "updated": "0001-01-01T00:00:00Z",
        "use_day_pricing": false,
        "use_tax_inclusive_pricing": false,
        "user_slug": "",
        "vehicle_amps": 0,
        "vehicle_box_length": 0,
        "vehicle_class": "",
        "vehicle_dry_weight": 0,
        "vehicle_gvwr": 5500,
        "vehicle_height": 0,
        "vehicle_length": 26,
        "vehicle_length_with_hitch": 0,
        "vehicle_license_plate_state": "NJ",
        "vehicle_make": "Coleman",
        "vehicle_model": "2605 light",
        "vehicle_title": "2017 Coleman 2605 light",
        "vehicle_width": 0,
        "vehicle_year": 2017,
        "weekly_discount": 1000
      },
      "relationships": {
        "images": {
          "data": [
            {
              "id": "3006110",
              "type": "images"
            },
            {
              "id": "3006108",
              "type": "images"
            },
            {
              "id": "3006107",
              "type": "images"
            },
            {
              "id": "3006109",
              "type": "images"
            },
            {
              "id": "3006111",
              "type": "images"
            },
            {
              "id": "3006112",
              "type": "images"
            },
            {
              "id": "3006113",
              "type": "images"
            },
            {
              "id": "3006114",
              "type": "images"
            },
            {
              "id": "3006115",
              "type": "images"
            },
            {
              "id": "3006116",
              "type": "images"
            },
            {
              "id": "3043098",
              "type": "images"
            },
            {
              "id": "3048506",
              "type": "images"
            }
          ]
        },
        "mileage_usage_item": {
          "data": {
            "id": "450591",
            "type": "usage_based_item"
          }
        },
        "owner": {
          "data": {
            "id": "3386784",
            "type": "users"
          }
        },
        "primary_image": {
          "data": {
            "id": "3006110",
            "type": "images"
          }
        }
      }
    },
    {
      "id": "286784",
      "type": "rentals",
      "attributes": {
        "Explanation": null,
        "FeaturesMap": null,
        "active_options": {
          "cancel_policy": "flexible",
          "cancel_policy_combo_bookings": "",
          "date": "2024-02-09",
          "instant_book": false,
          "minimum_days": 2,
          "monthly_discount_percentage": 15,
          "monthly_rate_per_day": 11730,
          "price_per_day": 13800,
          "price_per_month": 328440,
          "price_per_week": 86940,
          "tax": 0,
          "use_day_pricing": false,
          "use_tax_inclusive_pricing": false,
          "weekly_discount_percentage": 10,
          "weekly_rate_per_day": 12420
        },
        "availability_set": false,
        "average_ratings": {
          "cleanliness_score": 5,
          "cleanliness_score_percentage": 100,
          "communication_score": 5,
          "communication_score_percentage": 100,
          "listing_score": 5,
          "listing_score_percentage": 100,
          "mechanical_score": 4.5,
          "mechanical_score_percentage": 90,
          "score": 5,
          "score_percentage": 100,
          "value_score": 5,
          "value_score_percentage": 100
        },
        "average_reviews": {
          "owner": [],
          "rental": [],
          "score": 5
        },
        "campground": null,
        "campground_catalog": null,
        "campsite_category": null,
        "campsite_category_catalog": null,
        "cancel_policy": "flexible",
        "cancel_policy_combo_bookings": "",
        "cancel_text": "",
        "catalog": null,
        "check_in": 0,
        "check_out": 0,
        "children_count": 0,
        "coachnet_ready": true,
        "coachnet_required": false,
        "combined_special_hours": [],
        "created": "0001-01-01T00:00:00Z",
        "current_location_id": 0,
        "custom_insurance_text": "",
        "dealer": false,
        "delivery": false,
        "delivery_radius": 0,
        "delivery_usage_item_id": 353905,
        "deposit_percentage": 0,
        "description": "",
        "description_included": "There are lots of added amenities included. This camper comes with a backup camera, 3 sets of full size sheets, 1 set of RV queen sheets, 6 towels, 6 pillows, 4 single camping chairs, outdoor rug, folding table, a 5 cup coffee pot and fresh ground coffee, dinnerware for 6 (plates, bowls, cups, forks, spoons, knives), keypad lock with security code (so you never forget the keys), RV safe toilet paper, 24 inch smart TV,  outdoor grill, outdoor fridge to keep that beer cold, grilling/cooking gadgets(spatula, scissors, beer/wine opener, cutting board, peeler, grater, pizza cutter, tongs, large spoons, chefs knife etc.), 2 dish towels, cookware, bunk ladder,  1 x child bed bumper, first aid kit, outdoor shower, 6 x smores sticks  for those late night campfires pro-sway weight distribution hitch, and leveling blocks.",
        "description_other": "-We are pet friendly (but please let us know in advance for approval). \n-Vehicles with a towing Capacity of 5,000 lbs can pull this rig! Please check with us if you have any Q's. \n",
        "description_recommendations": "",
        "display_vehicle_type": "Travel trailer",
        "distributed_ratings": {
          "score": {
            "r1": 0,
            "r2": 0,
            "r3": 0,
            "r4": 0,
            "r5": 100
          }
        },
        "education": [],
        "external": false,
        "favorite": false,
        "favorite_count": 92,
        "features": {
          "air_conditioner": true,
          "audio_inputs": true,
          "awning": true,
          "backup_camera": true,
          "base_weight": 12539,
          "beds_bunk": null,
          "beds_dinette_conversion": null,
          "beds_fold_out_sofa": null,
          "beds_full": 0,
          "beds_king": 0,
          "beds_other": null,
          "beds_queen": 1,
          "beds_twin": 0,
          "bike_rack": false,
          "brake_controller": false,
          "burning_man_friendly": false,
          "carrying_capacity": 2961,
          "cd_player": false,
          "ceiling_fan": true,
          "connector_type": "7pin",
          "dining_table": true,
          "extra_storage": true,
          "festival_friendly": false,
          "generator": false,
          "gray_tank": 30,
          "gross_vehicle_weight": 0,
          "handicap_accessible": false,
          "heater": true,
          "hitch_weight": 430,
          "hookup_electric": false,
          "hookup_sewer": false,
          "hookup_water": false,
          "hot_water_tank": false,
          "inside_shower": true,
          "international_travel_allowed": false,
          "inverter": false,
          "kitchen_sink": true,
          "leveling_jacks": true,
          "microwave": true,
          "minimum_age": 0,
          "mpg": 0,
          "one_way_rentals": false,
          "outside_shower": true,
          "oven": false,
          "pet_friendly": true,
          "propane_tank": 20,
          "provides_receivers": true,
          "radio": true,
          "refrigerator": true,
          "satellite": false,
          "sewage_tank": 30,
          "skylight": true,
          "slide_outs": 3,
          "smoking_allowed": false,
          "solar": true,
          "stove": true,
          "tailgate_friendly": false,
          "toilet": true,
          "tow_hitch": false,
          "trailer_weight": 12539,
          "tv_dvd": true,
          "washer_dryer": false,
          "water_tank": 43,
          "wifi": false
        },
        "first_published": "2022-04-03T19:15:52.69692-07:00",
        "generator_usage_item_id": 0,
        "group_on_map": false,
        "group_reviews_num": 0,
        "group_reviews_score": 0,
        "group_score": 0,
        "has_been_published": true,
        "has_checkout_questions": false,
        "hidden": false,
        "host_notes": "",
        "house_rules": "No smoking/vaping/drug use inside trailer (If evidence of smoking is inside, your entire security deposit will not be refunded)\nNo climbing on the roof\nBlack and Grey tanks must be emptied before return\nCamper must be returned in the same condition as it was given to you, or you will be charged a ${'$'}100 cleaning fee  \nPlease dispose of all garbage before returning ",
        "instant_book": false,
        "instant_book_leeway": 0,
        "insurance_coverage": "",
        "insurance_eligible": true,
        "insurance_plan": {
          "id": 97,
          "label": "Outdoorsy Towable Protection",
          "renter_body": "",
          "renter_headline": "",
          "requires_driver_verification": false
        },
        "insurance_renter_adjustable": false,
        "insurance_state": "approved",
        "last_published": "2022-04-03T19:15:52.696862-07:00",
        "listing_questions": [
          {
            "answer": "We work during the week so pick up times must be before 11am or after 5pm. Drop offs must be before 12pm or we will charge an additional nightly fee. Renters must stay in communication to avoid any additional fees. ",
            "question": "What flexibility is available for picking up and dropping off the RV?"
          }
        ],
        "locale": {
          "base_currency": "USD",
          "distance_unit": "miles",
          "length_unit": "feet",
          "liquid_unit": "gallons",
          "weight_unit": "lbs"
        },
        "location": {
          "city": "Wayne",
          "country": "US",
          "county": "",
          "lat": 40.92,
          "lng": -74.255,
          "state": "NJ",
          "street": "262 Alps Rd",
          "zip": "07470"
        },
        "mileage_usage_item_id": 353907,
        "minimum_days": 0,
        "minimum_deposit": 0,
        "misc": null,
        "monthly_discount": 1500,
        "name": "Brand New, Clean, Family Friendly 2022 Travel Trailer",
        "nearby_content": [],
        "original_url": "",
        "owner_score": 0,
        "parent_id": 0,
        "position": 0,
        "preferred_primary_image": {
          "amenity": null,
          "best": false,
          "category": null,
          "description": "",
          "position": 0,
          "primary": false,
          "rental_id": 0,
          "review": null,
          "skip_enhance": false,
          "status": "",
          "tags": "",
          "url": "",
          "video": false
        },
        "prep_fee": {
          "amount": 15000,
          "description": "This fee will cover all restocking expenses for each trip"
        },
        "presentment_currency": "USD",
        "price_per_day": 13800,
        "price_per_month": 335340,
        "price_per_week": 82800,
        "primary_image_url": "https://res.cloudinary.com/outdoorsy/image/upload/v1648605383/p/rentals/286784/images/kqt64ccg1dtuijcskv7k.jpg",
        "pro": false,
        "published": true,
        "ranking": {
          "distance_weight": {
            "control": 0.35,
            "test_1": 0.6,
            "test_2": 0.35,
            "test_3": 0.35
          },
          "distance_weight_prod": 0.35,
          "is_new_listing": 0,
          "model_name": "model_gbt_web_072522",
          "original_score": 0,
          "ranking_score": 0.2513,
          "ranking_score2": 0.3588,
          "ranking_score3": 0.2513
        },
        "rental_category": "rv",
        "rental_score": 0,
        "request_less_than_minimum_days": 0,
        "review_scores": {
          "bayesian_rating": 3.544586601278424
        },
        "reviews_num": 8,
        "score": 5,
        "seatbelts": 0,
        "security_deposit": 80000,
        "seo_content": {
          "category": []
        },
        "settlement_currency": "USD",
        "sleeps": 7,
        "sleeps_adults": 0,
        "sleeps_kids": 0,
        "slug": "/rv-rental/wayne_nj/2022_forest-river_wildwood-fsx-178-bhsk_286784-listing",
        "smart_photo_score": 0,
        "sort_score": 3.0590405,
        "stay": null,
        "stay_catalog": null,
        "summary": "",
        "tags": [],
        "tax_rates": [],
        "type": "trailer",
        "unavailable": false,
        "updated": "0001-01-01T00:00:00Z",
        "use_day_pricing": false,
        "use_tax_inclusive_pricing": false,
        "user_slug": "",
        "vehicle_amps": 0,
        "vehicle_box_length": 0,
        "vehicle_class": "",
        "vehicle_dry_weight": 12539,
        "vehicle_gvwr": 4830,
        "vehicle_height": 0,
        "vehicle_length": 23,
        "vehicle_length_with_hitch": 0,
        "vehicle_license_plate_state": "NJ",
        "vehicle_make": "Forest River",
        "vehicle_model": "Other",
        "vehicle_title": "2022 Forest River Other",
        "vehicle_width": 0,
        "vehicle_year": 2022,
        "weekly_discount": 1000
      },
      "relationships": {
        "images": {
          "data": [
            {
              "id": "2384793",
              "type": "images"
            },
            {
              "id": "2408278",
              "type": "images"
            },
            {
              "id": "2408289",
              "type": "images"
            },
            {
              "id": "2384804",
              "type": "images"
            },
            {
              "id": "2384794",
              "type": "images"
            },
            {
              "id": "2408332",
              "type": "images"
            },
            {
              "id": "2408277",
              "type": "images"
            },
            {
              "id": "2408279",
              "type": "images"
            },
            {
              "id": "2408312",
              "type": "images"
            },
            {
              "id": "2408311",
              "type": "images"
            },
            {
              "id": "2408285",
              "type": "images"
            },
            {
              "id": "2408283",
              "type": "images"
            },
            {
              "id": "2408282",
              "type": "images"
            },
            {
              "id": "2408293",
              "type": "images"
            },
            {
              "id": "2408291",
              "type": "images"
            },
            {
              "id": "2408286",
              "type": "images"
            },
            {
              "id": "2408307",
              "type": "images"
            },
            {
              "id": "2408295",
              "type": "images"
            },
            {
              "id": "2408284",
              "type": "images"
            },
            {
              "id": "2408318",
              "type": "images"
            },
            {
              "id": "2408317",
              "type": "images"
            },
            {
              "id": "2408316",
              "type": "images"
            },
            {
              "id": "2408315",
              "type": "images"
            },
            {
              "id": "2408308",
              "type": "images"
            },
            {
              "id": "2408309",
              "type": "images"
            },
            {
              "id": "2408310",
              "type": "images"
            },
            {
              "id": "2408313",
              "type": "images"
            },
            {
              "id": "2408314",
              "type": "images"
            }
          ]
        },
        "mileage_usage_item": {
          "data": {
            "id": "353907",
            "type": "usage_based_item"
          }
        },
        "owner": {
          "data": {
            "id": "1920964",
            "type": "users"
          }
        },
        "primary_image": {
          "data": {
            "id": "2384793",
            "type": "images"
          }
        }
      }
    },
    {
      "id": "384054",
      "type": "rentals",
      "attributes": {
        "Explanation": null,
        "FeaturesMap": null,
        "active_options": {
          "cancel_policy": "flexible",
          "cancel_policy_combo_bookings": "",
          "date": "2024-02-09",
          "instant_book": false,
          "minimum_days": 2,
          "monthly_discount_percentage": 20,
          "monthly_rate_per_day": 5200,
          "price_per_day": 6500,
          "price_per_month": 145600,
          "price_per_week": 40950,
          "tax": 0,
          "use_day_pricing": false,
          "use_tax_inclusive_pricing": false,
          "weekly_discount_percentage": 10,
          "weekly_rate_per_day": 5850
        },
        "availability_set": false,
        "average_ratings": null,
        "average_reviews": null,
        "campground": null,
        "campground_catalog": null,
        "campsite_category": null,
        "campsite_category_catalog": null,
        "cancel_policy": "flexible",
        "cancel_policy_combo_bookings": "",
        "cancel_text": "",
        "catalog": null,
        "check_in": 0,
        "check_out": 0,
        "children_count": 0,
        "coachnet_ready": true,
        "coachnet_required": false,
        "combined_special_hours": [],
        "created": "0001-01-01T00:00:00Z",
        "current_location_id": 0,
        "custom_insurance_text": "",
        "dealer": false,
        "delivery": true,
        "delivery_radius": 100,
        "delivery_usage_item_id": 487918,
        "deposit_percentage": 0,
        "description": "",
        "description_included": "fresh linens, camping chairs. ",
        "description_other": "No smoking ",
        "description_recommendations": "",
        "display_vehicle_type": "Folding trailer",
        "distributed_ratings": null,
        "education": [],
        "external": false,
        "favorite": false,
        "favorite_count": 6,
        "features": {
          "air_conditioner": true,
          "audio_inputs": true,
          "awning": true,
          "backup_camera": false,
          "beds_bunk": null,
          "beds_dinette_conversion": null,
          "beds_fold_out_sofa": null,
          "beds_full": 0,
          "beds_king": 0,
          "beds_other": null,
          "beds_queen": 2,
          "beds_twin": 0,
          "bike_rack": false,
          "brake_controller": false,
          "burning_man_friendly": true,
          "cd_player": false,
          "ceiling_fan": true,
          "connector_type": null,
          "dining_table": true,
          "extra_storage": true,
          "festival_friendly": false,
          "generator": true,
          "gray_tank": 0,
          "handicap_accessible": false,
          "heater": true,
          "hitch_weight": null,
          "hookup_electric": true,
          "hookup_sewer": true,
          "hookup_water": true,
          "hot_water_tank": false,
          "inside_shower": false,
          "international_travel_allowed": false,
          "inverter": false,
          "kitchen_sink": true,
          "leveling_jacks": true,
          "microwave": true,
          "minimum_age": 0,
          "mpg": 0,
          "one_way_rentals": false,
          "outside_shower": true,
          "oven": false,
          "pet_friendly": true,
          "propane_tank": 15,
          "provides_receivers": false,
          "radio": true,
          "refrigerator": true,
          "satellite": false,
          "sewage_tank": 0,
          "skylight": true,
          "slide_outs": 0,
          "smoking_allowed": false,
          "solar": true,
          "stove": true,
          "tailgate_friendly": false,
          "toilet": false,
          "tow_hitch": false,
          "trailer_weight": null,
          "tv_dvd": false,
          "washer_dryer": false,
          "water_tank": 30,
          "wifi": false
        },
        "first_published": "2023-09-11T15:04:51.530602-07:00",
        "generator_usage_item_id": 487920,
        "group_on_map": false,
        "group_reviews_num": 0,
        "group_reviews_score": 0,
        "group_score": 0,
        "has_been_published": true,
        "has_checkout_questions": false,
        "hidden": false,
        "host_notes": "",
        "house_rules": "",
        "instant_book": false,
        "instant_book_leeway": 0,
        "insurance_coverage": "",
        "insurance_eligible": true,
        "insurance_plan": {
          "id": 97,
          "label": "Outdoorsy Towable Protection",
          "renter_body": "",
          "renter_headline": "",
          "requires_driver_verification": false
        },
        "insurance_renter_adjustable": false,
        "insurance_state": "approved",
        "last_published": "2023-09-11T15:04:51.530544-07:00",
        "listing_questions": [],
        "locale": {
          "base_currency": "USD",
          "distance_unit": "miles",
          "length_unit": "feet",
          "liquid_unit": "gallons",
          "weight_unit": "lbs"
        },
        "location": {
          "city": "Brooklyn",
          "country": "US",
          "county": "",
          "lat": 40.594,
          "lng": -73.926,
          "state": "NY",
          "street": "2664 Gerritsen Avenue",
          "zip": "11229"
        },
        "mileage_usage_item_id": 487921,
        "minimum_days": 0,
        "minimum_deposit": 0,
        "misc": null,
        "monthly_discount": 2000,
        "name": "Cozy, Easy to Towing, Lovely Pop Up Camper in Brooklyn",
        "nearby_content": [],
        "original_url": "",
        "owner_score": 0,
        "parent_id": 0,
        "position": 0,
        "preferred_primary_image": {
          "amenity": null,
          "best": false,
          "category": null,
          "description": "",
          "position": 0,
          "primary": false,
          "rental_id": 0,
          "review": null,
          "skip_enhance": false,
          "status": "",
          "tags": "",
          "url": "",
          "video": false
        },
        "prep_fee": {
          "amount": 5000,
          "description": "This fee will cover preparing and sanitizing the unit prior to each rental."
        },
        "presentment_currency": "USD",
        "price_per_day": 6500,
        "price_per_month": 157950,
        "price_per_week": 39000,
        "primary_image_url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694469620/p/rentals/384054/images/xrkwyplzdalexmtnsvcs.jpg",
        "pro": false,
        "published": true,
        "ranking": {
          "distance_weight": {
            "control": 0.35,
            "test_1": 0.6,
            "test_2": 0.35,
            "test_3": 0.35
          },
          "distance_weight_prod": 0.35,
          "is_new_listing": 0,
          "model_name": "model_gbt_web_072522",
          "original_score": 0,
          "ranking_score": 0.2441,
          "ranking_score2": 0.5484,
          "ranking_score3": 0.2441
        },
        "rental_category": "rv",
        "rental_score": 0,
        "request_less_than_minimum_days": 0,
        "review_scores": null,
        "reviews_num": 0,
        "score": 0,
        "seatbelts": 4,
        "security_deposit": 50000,
        "seo_content": {
          "category": []
        },
        "settlement_currency": "USD",
        "sleeps": 4,
        "sleeps_adults": 0,
        "sleeps_kids": 0,
        "slug": "/rv-rental/brooklyn_ny/2005_1pac56r145m028597_palomino-pony_384054-listing",
        "smart_photo_score": 0,
        "sort_score": 3.0502262,
        "stay": null,
        "stay_catalog": null,
        "summary": "",
        "tags": [],
        "tax_rates": [],
        "type": "folding-trailer",
        "unavailable": false,
        "updated": "0001-01-01T00:00:00Z",
        "use_day_pricing": false,
        "use_tax_inclusive_pricing": false,
        "user_slug": "",
        "vehicle_amps": 0,
        "vehicle_box_length": 0,
        "vehicle_class": "",
        "vehicle_dry_weight": 0,
        "vehicle_gvwr": 0,
        "vehicle_height": 0,
        "vehicle_length": 16,
        "vehicle_length_with_hitch": 0,
        "vehicle_license_plate_state": "NY",
        "vehicle_make": "1PAC56R145M028597",
        "vehicle_model": "Palomino Pony",
        "vehicle_title": "2005 1PAC56R145M028597 Palomino Pony",
        "vehicle_width": 0,
        "vehicle_year": 2005,
        "weekly_discount": 1000
      },
      "relationships": {
        "generator_usage_item": {
          "data": {
            "id": "487920",
            "type": "usage_based_item"
          }
        },
        "images": {
          "data": [
            {
              "id": "3244499",
              "type": "images"
            },
            {
              "id": "3244501",
              "type": "images"
            },
            {
              "id": "3244498",
              "type": "images"
            },
            {
              "id": "3244500",
              "type": "images"
            },
            {
              "id": "3244503",
              "type": "images"
            },
            {
              "id": "3244504",
              "type": "images"
            },
            {
              "id": "3244505",
              "type": "images"
            },
            {
              "id": "3244506",
              "type": "images"
            },
            {
              "id": "3244507",
              "type": "images"
            },
            {
              "id": "3244508",
              "type": "images"
            },
            {
              "id": "3244509",
              "type": "images"
            },
            {
              "id": "3244510",
              "type": "images"
            },
            {
              "id": "3244511",
              "type": "images"
            }
          ]
        },
        "mileage_usage_item": {
          "data": {
            "id": "487921",
            "type": "usage_based_item"
          }
        },
        "owner": {
          "data": {
            "id": "2221265",
            "type": "users"
          }
        },
        "primary_image": {
          "data": {
            "id": "3244499",
            "type": "images"
          }
        }
      }
    },
    {
      "id": "347204",
      "type": "rentals",
      "attributes": {
        "Explanation": null,
        "FeaturesMap": null,
        "active_options": {
          "cancel_policy": "flexible",
          "cancel_policy_combo_bookings": "",
          "date": "2024-02-09",
          "instant_book": false,
          "minimum_days": 1,
          "monthly_discount_percentage": 25,
          "monthly_rate_per_day": 6375,
          "price_per_day": 8500,
          "price_per_month": 178500,
          "price_per_week": 53550,
          "tax": 0,
          "use_day_pricing": false,
          "use_tax_inclusive_pricing": false,
          "weekly_discount_percentage": 10,
          "weekly_rate_per_day": 7650
        },
        "availability_set": false,
        "average_ratings": null,
        "average_reviews": null,
        "campground": null,
        "campground_catalog": null,
        "campsite_category": null,
        "campsite_category_catalog": null,
        "cancel_policy": "flexible",
        "cancel_policy_combo_bookings": "",
        "cancel_text": "",
        "catalog": null,
        "check_in": 0,
        "check_out": 0,
        "children_count": 0,
        "coachnet_ready": true,
        "coachnet_required": false,
        "combined_special_hours": [],
        "created": "0001-01-01T00:00:00Z",
        "current_location_id": 0,
        "custom_insurance_text": "",
        "dealer": false,
        "delivery": true,
        "delivery_radius": 75,
        "delivery_usage_item_id": 435862,
        "deposit_percentage": 0,
        "description": "",
        "description_included": "8 E-Track rails, and a bag of accessories and straps. Two hitches available, one is a Weigh Safe with a scale built in, and the other is an Anderson No Sway load distribution system.",
        "description_other": "",
        "description_recommendations": "",
        "display_vehicle_type": "Other",
        "distributed_ratings": null,
        "education": [],
        "external": false,
        "favorite": false,
        "favorite_count": 1,
        "features": {
          "air_conditioner": false,
          "audio_inputs": false,
          "awning": false,
          "backup_camera": false,
          "beds_bunk": null,
          "beds_dinette_conversion": null,
          "beds_fold_out_sofa": null,
          "beds_full": 0,
          "beds_king": 0,
          "beds_other": null,
          "beds_queen": 0,
          "beds_twin": 0,
          "bike_rack": false,
          "brake_controller": false,
          "burning_man_friendly": true,
          "cd_player": false,
          "ceiling_fan": false,
          "connector_type": null,
          "dining_table": false,
          "extra_storage": false,
          "festival_friendly": false,
          "fuel_tank": 0,
          "fuel_type": "",
          "generator": false,
          "gray_tank": 0,
          "handicap_accessible": false,
          "heater": false,
          "hitch_weight": 0,
          "hookup_electric": false,
          "hookup_sewer": false,
          "hookup_water": false,
          "hot_water_tank": false,
          "inside_shower": false,
          "international_travel_allowed": false,
          "inverter": false,
          "kitchen_sink": false,
          "leveling_jacks": true,
          "microwave": false,
          "minimum_age": 0,
          "mpg": 0,
          "one_way_rentals": false,
          "outside_shower": false,
          "oven": false,
          "pet_friendly": true,
          "propane_tank": 0,
          "provides_receivers": false,
          "radio": false,
          "refrigerator": false,
          "satellite": false,
          "sewage_tank": 0,
          "skylight": false,
          "slide_outs": 0,
          "smoking_allowed": true,
          "solar": false,
          "stove": false,
          "tailgate_friendly": true,
          "toilet": false,
          "tow_hitch": false,
          "trailer_weight": 0,
          "transmission": "",
          "tv_dvd": false,
          "washer_dryer": false,
          "water_tank": 0,
          "wifi": false
        },
        "first_published": "2023-02-27T12:05:22.419793-08:00",
        "generator_usage_item_id": 435864,
        "group_on_map": false,
        "group_reviews_num": 0,
        "group_reviews_score": 0,
        "group_score": 0,
        "has_been_published": true,
        "has_checkout_questions": false,
        "hidden": false,
        "host_notes": "",
        "house_rules": "",
        "instant_book": false,
        "instant_book_leeway": 0,
        "insurance_coverage": "",
        "insurance_eligible": false,
        "insurance_renter_adjustable": false,
        "insurance_state": "approved",
        "last_published": "2023-02-27T12:05:22.419714-08:00",
        "listing_questions": [],
        "locale": {
          "base_currency": "USD",
          "distance_unit": "miles",
          "length_unit": "feet",
          "liquid_unit": "gallons",
          "weight_unit": "lbs"
        },
        "location": {
          "city": "Stratford",
          "country": "US",
          "county": "",
          "lat": 41.212,
          "lng": -73.132,
          "state": "CT",
          "street": "345 Huntington Rd",
          "zip": "06614"
        },
        "mileage_usage_item_id": 435863,
        "minimum_days": 0,
        "minimum_deposit": 0,
        "misc": null,
        "monthly_discount": 2500,
        "name": "2023 J&C 8.5 x 18 Cargo Trailer - Enclosed - V Nose",
        "nearby_content": [],
        "original_url": "",
        "owner_score": 0,
        "parent_id": 0,
        "position": 0,
        "preferred_primary_image": {
          "amenity": null,
          "best": false,
          "category": null,
          "description": "",
          "position": 0,
          "primary": false,
          "rental_id": 0,
          "review": null,
          "skip_enhance": false,
          "status": "",
          "tags": "",
          "url": "",
          "video": false
        },
        "prep_fee": {
          "amount": 0,
          "description": "This fee will cover preparing and sanitizing the unit prior to each rental."
        },
        "presentment_currency": "USD",
        "price_per_day": 8500,
        "price_per_month": 206550,
        "price_per_week": 51000,
        "primary_image_url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528082/p/rentals/347204/images/tcx1cmdhd1rgeabtwctk.jpg",
        "pro": false,
        "published": true,
        "ranking": {
          "distance_weight": {
            "control": 0.35,
            "test_1": 0.6,
            "test_2": 0.35,
            "test_3": 0.35
          },
          "distance_weight_prod": 0.35,
          "is_new_listing": 0,
          "model_name": "model_gbt_web_072522",
          "original_score": 0,
          "ranking_score": 0.5591,
          "ranking_score2": 0.4274,
          "ranking_score3": 0.5591
        },
        "rental_category": "rv",
        "rental_score": 0,
        "request_less_than_minimum_days": 0,
        "review_scores": null,
        "reviews_num": 0,
        "score": 0,
        "seatbelts": 1,
        "security_deposit": 50000,
        "seo_content": {
          "category": []
        },
        "settlement_currency": "USD",
        "sleeps": 1,
        "sleeps_adults": 0,
        "sleeps_kids": 0,
        "slug": "/rv-rental/stratford_ct/2023_j-c_8-5x18ta_347204-listing",
        "smart_photo_score": 0,
        "sort_score": 2.987219,
        "stay": null,
        "stay_catalog": null,
        "summary": "",
        "tags": [],
        "tax_rates": [],
        "type": "other",
        "unavailable": false,
        "updated": "0001-01-01T00:00:00Z",
        "use_day_pricing": false,
        "use_tax_inclusive_pricing": false,
        "user_slug": "",
        "vehicle_amps": 0,
        "vehicle_box_length": 0,
        "vehicle_class": "",
        "vehicle_dry_weight": 0,
        "vehicle_gvwr": 0,
        "vehicle_height": 0,
        "vehicle_length": 21.5,
        "vehicle_length_with_hitch": 0,
        "vehicle_license_plate_state": "ME",
        "vehicle_make": "J&C",
        "vehicle_model": "8.5x18TA",
        "vehicle_title": "2023 J&C 8.5x18TA",
        "vehicle_width": 0,
        "vehicle_year": 2023,
        "weekly_discount": 1000
      },
      "relationships": {
        "generator_usage_item": {
          "data": {
            "id": "435864",
            "type": "usage_based_item"
          }
        },
        "images": {
          "data": [
            {
              "id": "2902488",
              "type": "images"
            },
            {
              "id": "2902497",
              "type": "images"
            },
            {
              "id": "2902499",
              "type": "images"
            },
            {
              "id": "2902500",
              "type": "images"
            },
            {
              "id": "2902501",
              "type": "images"
            },
            {
              "id": "2902505",
              "type": "images"
            },
            {
              "id": "2902506",
              "type": "images"
            },
            {
              "id": "2902503",
              "type": "images"
            },
            {
              "id": "2902502",
              "type": "images"
            },
            {
              "id": "2902507",
              "type": "images"
            }
          ]
        },
        "mileage_usage_item": {
          "data": {
            "id": "435863",
            "type": "usage_based_item"
          }
        },
        "owner": {
          "data": {
            "id": "2719335",
            "type": "users"
          }
        },
        "primary_image": {
          "data": {
            "id": "2902488",
            "type": "images"
          }
        }
      }
    },
    {
      "id": "269643",
      "type": "rentals",
      "attributes": {
        "Explanation": null,
        "FeaturesMap": null,
        "active_options": {
          "cancel_policy": "flexible",
          "cancel_policy_combo_bookings": "",
          "date": "2024-02-09",
          "instant_book": false,
          "minimum_days": 1,
          "monthly_discount_percentage": 0,
          "monthly_rate_per_day": 5000,
          "price_per_day": 5000,
          "price_per_month": 140000,
          "price_per_week": 35000,
          "tax": 0,
          "use_day_pricing": false,
          "use_tax_inclusive_pricing": false,
          "weekly_discount_percentage": 0,
          "weekly_rate_per_day": 5000
        },
        "availability_set": false,
        "average_ratings": null,
        "average_reviews": null,
        "campground": null,
        "campground_catalog": null,
        "campsite_category": null,
        "campsite_category_catalog": null,
        "cancel_policy": "flexible",
        "cancel_policy_combo_bookings": "",
        "cancel_text": "",
        "catalog": null,
        "check_in": 0,
        "check_out": 0,
        "children_count": 0,
        "coachnet_ready": true,
        "coachnet_required": false,
        "combined_special_hours": [],
        "created": "0001-01-01T00:00:00Z",
        "current_location_id": 0,
        "custom_insurance_text": "",
        "dealer": false,
        "delivery": true,
        "delivery_radius": 5,
        "delivery_usage_item_id": 330892,
        "deposit_percentage": 0,
        "description": "",
        "description_included": "",
        "description_other": "",
        "description_recommendations": "",
        "display_vehicle_type": "",
        "distributed_ratings": null,
        "education": [],
        "external": false,
        "favorite": false,
        "favorite_count": 0,
        "features": {
          "air_conditioner": false,
          "audio_inputs": false,
          "awning": false,
          "backup_camera": false,
          "beds_full": 0,
          "beds_king": 0,
          "beds_queen": 0,
          "beds_twin": 0,
          "bike_rack": false,
          "burning_man_friendly": false,
          "cd_player": false,
          "dining_table": false,
          "extra_storage": false,
          "generator": false,
          "gray_tank": 0,
          "handicap_accessible": false,
          "heater": false,
          "hitch_weight": null,
          "hot_water_tank": false,
          "inside_shower": false,
          "inverter": false,
          "kitchen_sink": false,
          "leveling_jacks": false,
          "microwave": false,
          "minimum_age": 0,
          "mpg": 0,
          "one_way_rentals": false,
          "outside_shower": false,
          "oven": false,
          "pet_friendly": false,
          "propane_tank": 0,
          "radio": false,
          "refrigerator": false,
          "satellite": false,
          "sewage_tank": 0,
          "skylight": false,
          "slide_outs": 0,
          "smoking_allowed": false,
          "solar": false,
          "stove": false,
          "tailgate_friendly": false,
          "toilet": false,
          "tow_hitch": false,
          "trailer_weight": null,
          "tv_dvd": false,
          "washer_dryer": false,
          "water_tank": 0,
          "wifi": false
        },
        "first_published": "2021-11-11T12:36:57.237056-08:00",
        "generator_usage_item_id": 0,
        "group_on_map": false,
        "group_reviews_num": 0,
        "group_reviews_score": 0,
        "group_score": 0,
        "has_been_published": true,
        "has_checkout_questions": false,
        "hidden": false,
        "host_notes": "",
        "house_rules": "",
        "instant_book": false,
        "instant_book_leeway": 1,
        "insurance_coverage": "",
        "insurance_eligible": true,
        "insurance_plan": {
          "id": 97,
          "label": "Outdoorsy Towable Protection",
          "renter_body": "",
          "renter_headline": "",
          "requires_driver_verification": false
        },
        "insurance_renter_adjustable": false,
        "insurance_state": "approved",
        "last_published": "2021-11-11T12:36:57.23701-08:00",
        "listing_questions": [],
        "locale": {
          "base_currency": "USD",
          "distance_unit": "miles",
          "length_unit": "feet",
          "liquid_unit": "gallons",
          "weight_unit": "lbs"
        },
        "location": {
          "city": "Willingboro",
          "country": "US",
          "county": "",
          "lat": 40.026,
          "lng": -74.867,
          "state": "NJ",
          "street": "44 Earnshaw Ln",
          "zip": "08046"
        },
        "mileage_usage_item_id": 0,
        "minimum_days": 0,
        "minimum_deposit": 0,
        "misc": null,
        "monthly_discount": 0,
        "name": "9x6 Utility Trailer!",
        "nearby_content": [],
        "original_url": "",
        "owner_score": 0,
        "parent_id": 0,
        "position": 0,
        "preferred_primary_image": {
          "amenity": null,
          "best": false,
          "category": null,
          "description": "",
          "position": 0,
          "primary": false,
          "rental_id": 0,
          "review": null,
          "skip_enhance": false,
          "status": "",
          "tags": "",
          "url": "",
          "video": false
        },
        "prep_fee": {
          "amount": 0,
          "description": ""
        },
        "presentment_currency": "USD",
        "price_per_day": 5000,
        "price_per_month": 135000,
        "price_per_week": 30000,
        "primary_image_url": "https://res.cloudinary.com/outdoorsy/image/upload/v1636660753/undefined/rentals/269643/images/oulcqox9zo52ovbojttb.jpg",
        "pro": false,
        "published": true,
        "ranking": {
          "distance_weight": {
            "control": 0.35,
            "test_1": 0.6,
            "test_2": 0.35,
            "test_3": 0.35
          },
          "distance_weight_prod": 0.35,
          "is_new_listing": 0,
          "model_name": "model_gbt_web_072522",
          "original_score": 0,
          "ranking_score": 0.6135,
          "ranking_score2": 0.6403,
          "ranking_score3": 0.6135
        },
        "rental_category": "rv",
        "rental_score": 0,
        "request_less_than_minimum_days": 0,
        "review_scores": null,
        "reviews_num": 0,
        "score": 0,
        "seatbelts": 0,
        "security_deposit": 50000,
        "seo_content": {
          "category": [
            {
              "id": 202486,
              "title": "Utility Trailer rental by location",
              "url": "https://www.outdoorsy.com/rv-makes-types/utility-trailer-rental"
            },
            {
              "id": 203894,
              "title": "New Jersey Utility Trailer rental",
              "url": "https://www.outdoorsy.com/rv-makes-types/utility-trailer-rental/NJ"
            }
          ]
        },
        "settlement_currency": "USD",
        "sleeps": 0,
        "sleeps_adults": 0,
        "sleeps_kids": 0,
        "slug": "/rv-rental/willingboro_nj/2021_lowes_8_269643-listing",
        "smart_photo_score": 0,
        "sort_score": 2.802045,
        "stay": null,
        "stay_catalog": null,
        "summary": "",
        "tags": [],
        "tax_rates": [],
        "type": "utility-trailer",
        "unavailable": false,
        "updated": "0001-01-01T00:00:00Z",
        "use_day_pricing": false,
        "use_tax_inclusive_pricing": false,
        "user_slug": "",
        "vehicle_amps": 0,
        "vehicle_box_length": 0,
        "vehicle_class": "",
        "vehicle_dry_weight": 0,
        "vehicle_gvwr": 0,
        "vehicle_height": 0,
        "vehicle_length": 9,
        "vehicle_length_with_hitch": 0,
        "vehicle_license_plate_state": "OH",
        "vehicle_make": "Lowes",
        "vehicle_model": "8",
        "vehicle_title": "2021 Lowes 8",
        "vehicle_width": 0,
        "vehicle_year": 2021,
        "weekly_discount": 0
      },
      "relationships": {
        "images": {
          "data": [
            {
              "id": "2203269",
              "type": "images"
            },
            {
              "id": "2203270",
              "type": "images"
            },
            {
              "id": "2203271",
              "type": "images"
            },
            {
              "id": "2203272",
              "type": "images"
            }
          ]
        },
        "owner": {
          "data": {
            "id": "2228248",
            "type": "users"
          }
        },
        "primary_image": {
          "data": {
            "id": "2203269",
            "type": "images"
          }
        }
      }
    },
    {
      "id": "369764",
      "type": "rentals",
      "attributes": {
        "Explanation": null,
        "FeaturesMap": null,
        "active_options": {
          "cancel_policy": "flexible",
          "cancel_policy_combo_bookings": "",
          "date": "2024-02-09",
          "instant_book": true,
          "minimum_days": 1,
          "monthly_discount_percentage": 20,
          "monthly_rate_per_day": 15120,
          "price_per_day": 18900,
          "price_per_month": 423360,
          "price_per_week": 119070,
          "tax": 0,
          "use_day_pricing": false,
          "use_tax_inclusive_pricing": false,
          "weekly_discount_percentage": 10,
          "weekly_rate_per_day": 17010
        },
        "availability_set": false,
        "average_ratings": {
          "cleanliness_score": 5,
          "cleanliness_score_percentage": 100,
          "communication_score": 5,
          "communication_score_percentage": 100,
          "listing_score": 5,
          "listing_score_percentage": 100,
          "mechanical_score": 5,
          "mechanical_score_percentage": 100,
          "score": 5,
          "score_percentage": 100,
          "value_score": 5,
          "value_score_percentage": 100
        },
        "average_reviews": null,
        "campground": null,
        "campground_catalog": null,
        "campsite_category": null,
        "campsite_category_catalog": null,
        "cancel_policy": "flexible",
        "cancel_policy_combo_bookings": "",
        "cancel_text": "",
        "catalog": null,
        "check_in": 0,
        "check_out": 0,
        "children_count": 0,
        "coachnet_ready": true,
        "coachnet_required": false,
        "combined_special_hours": [],
        "created": "0001-01-01T00:00:00Z",
        "current_location_id": 0,
        "custom_insurance_text": "",
        "dealer": false,
        "delivery": true,
        "delivery_radius": 100,
        "delivery_usage_item_id": 467426,
        "deposit_percentage": 0,
        "description": "",
        "description_included": "",
        "description_other": "",
        "description_recommendations": "",
        "display_vehicle_type": "Travel trailer",
        "distributed_ratings": {
          "score": {
            "r1": 0,
            "r2": 0,
            "r3": 0,
            "r4": 0,
            "r5": 100
          }
        },
        "education": [],
        "external": false,
        "favorite": false,
        "favorite_count": 26,
        "features": {
          "air_conditioner": true,
          "audio_inputs": true,
          "awning": true,
          "backup_camera": false,
          "beds_bunk": null,
          "beds_dinette_conversion": null,
          "beds_fold_out_sofa": null,
          "beds_full": 0,
          "beds_king": 0,
          "beds_other": null,
          "beds_queen": 0,
          "beds_twin": 0,
          "bike_rack": false,
          "brake_controller": false,
          "burning_man_friendly": true,
          "cd_player": true,
          "ceiling_fan": true,
          "connector_type": null,
          "dining_table": true,
          "extra_storage": true,
          "festival_friendly": false,
          "generator": false,
          "gray_tank": 0,
          "handicap_accessible": false,
          "heater": true,
          "hitch_weight": 600,
          "hookup_electric": true,
          "hookup_sewer": true,
          "hookup_water": true,
          "hot_water_tank": false,
          "inside_shower": true,
          "international_travel_allowed": false,
          "inverter": false,
          "kitchen_sink": true,
          "leveling_jacks": true,
          "microwave": true,
          "minimum_age": 0,
          "mpg": 0,
          "one_way_rentals": false,
          "outside_shower": true,
          "oven": true,
          "pet_friendly": true,
          "propane_tank": 0,
          "provides_receivers": false,
          "radio": true,
          "refrigerator": true,
          "satellite": true,
          "sewage_tank": 0,
          "skylight": true,
          "slide_outs": 1,
          "smoking_allowed": false,
          "solar": false,
          "stove": true,
          "tailgate_friendly": true,
          "toilet": true,
          "tow_hitch": false,
          "trailer_weight": 7700,
          "tv_dvd": true,
          "washer_dryer": false,
          "water_tank": 0,
          "wifi": false
        },
        "first_published": "2023-06-26T09:31:48.996935-07:00",
        "generator_usage_item_id": 0,
        "group_on_map": false,
        "group_reviews_num": 0,
        "group_reviews_score": 0,
        "group_score": 0,
        "has_been_published": true,
        "has_checkout_questions": false,
        "hidden": false,
        "host_notes": "",
        "house_rules": "",
        "instant_book": true,
        "instant_book_leeway": 0,
        "insurance_coverage": "",
        "insurance_eligible": true,
        "insurance_plan": {
          "id": 97,
          "label": "Outdoorsy Towable Protection",
          "renter_body": "",
          "renter_headline": "",
          "requires_driver_verification": false
        },
        "insurance_renter_adjustable": false,
        "insurance_state": "approved",
        "last_published": "2023-06-26T09:31:48.996901-07:00",
        "listing_questions": [],
        "locale": {
          "base_currency": "USD",
          "distance_unit": "miles",
          "length_unit": "feet",
          "liquid_unit": "gallons",
          "weight_unit": "lbs"
        },
        "location": {
          "city": "Suffern",
          "country": "US",
          "county": "",
          "lat": 41.142,
          "lng": -74.104,
          "state": "NY",
          "street": "23 golden road",
          "zip": "10901"
        },
        "mileage_usage_item_id": 467427,
        "minimum_days": 0,
        "minimum_deposit": 0,
        "misc": null,
        "monthly_discount": 2000,
        "name": "2021 Grand Design Imagine",
        "nearby_content": [],
        "original_url": "",
        "owner_score": 0,
        "parent_id": 0,
        "position": 0,
        "preferred_primary_image": {
          "amenity": null,
          "best": false,
          "category": null,
          "description": "",
          "position": 0,
          "primary": false,
          "rental_id": 0,
          "review": null,
          "skip_enhance": false,
          "status": "",
          "tags": "",
          "url": "",
          "video": false
        },
        "prep_fee": {
          "amount": 25000,
          "description": "This fee will cover preparing and sanitizing the unit prior to each rental."
        },
        "presentment_currency": "USD",
        "price_per_day": 18900,
        "price_per_month": 459270,
        "price_per_week": 113400,
        "primary_image_url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797072/undefined/rentals/369764/images/ahdswxkqtsipn4uo99jn.jpg",
        "pro": false,
        "published": true,
        "ranking": {
          "distance_weight": {
            "control": 0.35,
            "test_1": 0.6,
            "test_2": 0.35,
            "test_3": 0.35
          },
          "distance_weight_prod": 0.35,
          "is_new_listing": 0,
          "model_name": "model_gbt_web_072522",
          "original_score": 0,
          "ranking_score": 0.292,
          "ranking_score2": 0.2155,
          "ranking_score3": 0.292
        },
        "rental_category": "rv",
        "rental_score": 0,
        "request_less_than_minimum_days": 0,
        "review_scores": {
          "bayesian_rating": 2.229018732900877
        },
        "reviews_num": 1,
        "score": 5,
        "seatbelts": 0,
        "security_deposit": 50000,
        "seo_content": {
          "category": []
        },
        "settlement_currency": "USD",
        "sleeps": 6,
        "sleeps_adults": 0,
        "sleeps_kids": 0,
        "slug": "/rv-rental/suffern_ny/2021_grand-design_imagine_369764-listing",
        "smart_photo_score": 0,
        "sort_score": 2.7615743,
        "stay": null,
        "stay_catalog": null,
        "summary": "",
        "tags": [],
        "tax_rates": [],
        "type": "trailer",
        "unavailable": false,
        "updated": "0001-01-01T00:00:00Z",
        "use_day_pricing": false,
        "use_tax_inclusive_pricing": false,
        "user_slug": "",
        "vehicle_amps": 0,
        "vehicle_box_length": 0,
        "vehicle_class": "",
        "vehicle_dry_weight": 0,
        "vehicle_gvwr": 0,
        "vehicle_height": 0,
        "vehicle_length": 36,
        "vehicle_length_with_hitch": 0,
        "vehicle_license_plate_state": "NY",
        "vehicle_make": "Grand Design",
        "vehicle_model": "Imagine",
        "vehicle_title": "2021 Grand Design Imagine",
        "vehicle_width": 0,
        "vehicle_year": 2021,
        "weekly_discount": 1000
      },
      "relationships": {
        "images": {
          "data": [
            {
              "id": "3117669",
              "type": "images"
            },
            {
              "id": "3117670",
              "type": "images"
            },
            {
              "id": "3117671",
              "type": "images"
            },
            {
              "id": "3117672",
              "type": "images"
            },
            {
              "id": "3117673",
              "type": "images"
            },
            {
              "id": "3117674",
              "type": "images"
            },
            {
              "id": "3117675",
              "type": "images"
            },
            {
              "id": "3117676",
              "type": "images"
            },
            {
              "id": "3117677",
              "type": "images"
            },
            {
              "id": "3117678",
              "type": "images"
            },
            {
              "id": "3117679",
              "type": "images"
            }
          ]
        },
        "mileage_usage_item": {
          "data": {
            "id": "467427",
            "type": "usage_based_item"
          }
        },
        "owner": {
          "data": {
            "id": "3512182",
            "type": "users"
          }
        },
        "primary_image": {
          "data": {
            "id": "3117669",
            "type": "images"
          }
        }
      }
    },
    {
      "id": "159587",
      "type": "rentals",
      "attributes": {
        "Explanation": null,
        "FeaturesMap": null,
        "active_options": {
          "cancel_policy": "moderate",
          "cancel_policy_combo_bookings": "",
          "date": "2024-02-09",
          "instant_book": false,
          "minimum_days": 2,
          "monthly_discount_percentage": -10.1,
          "monthly_rate_per_day": 7700,
          "price_per_day": 7000,
          "price_per_month": 215600,
          "price_per_week": 53900,
          "tax": 0,
          "use_day_pricing": false,
          "use_tax_inclusive_pricing": false,
          "weekly_discount_percentage": -10.1,
          "weekly_rate_per_day": 7700
        },
        "availability_set": false,
        "average_ratings": null,
        "average_reviews": null,
        "campground": null,
        "campground_catalog": null,
        "campsite_category": null,
        "campsite_category_catalog": null,
        "cancel_policy": "moderate",
        "cancel_policy_combo_bookings": "",
        "cancel_text": "",
        "catalog": null,
        "check_in": 0,
        "check_out": 0,
        "children_count": 0,
        "coachnet_ready": true,
        "coachnet_required": false,
        "combined_special_hours": [],
        "created": "0001-01-01T00:00:00Z",
        "current_location_id": 0,
        "custom_insurance_text": "",
        "dealer": false,
        "delivery": true,
        "delivery_radius": 60,
        "delivery_usage_item_id": 184972,
        "deposit_percentage": 0,
        "description": "",
        "description_included": "",
        "description_other": "",
        "description_recommendations": "",
        "display_vehicle_type": "Tow Vehicle",
        "distributed_ratings": null,
        "education": [],
        "external": false,
        "favorite": false,
        "favorite_count": 3,
        "features": {
          "air_conditioner": false,
          "audio_inputs": false,
          "awning": false,
          "backup_camera": false,
          "base_weight": 1200,
          "beds_bunk": null,
          "beds_dinette_conversion": null,
          "beds_fold_out_sofa": null,
          "beds_full": 0,
          "beds_king": 0,
          "beds_other": null,
          "beds_queen": 0,
          "beds_twin": 0,
          "bike_rack": false,
          "brake_controller": false,
          "burning_man_friendly": true,
          "carrying_capacity": 3000,
          "cd_player": false,
          "ceiling_fan": false,
          "connector_type": null,
          "dining_table": false,
          "extra_storage": false,
          "festival_friendly": true,
          "fuel_tank": 0,
          "fuel_type": "",
          "generator": false,
          "gray_tank": 0,
          "gross_vehicle_weight": 0,
          "handicap_accessible": false,
          "heater": false,
          "hitch_weight": 150,
          "hookup_electric": false,
          "hookup_sewer": false,
          "hookup_water": false,
          "hot_water_tank": false,
          "inside_shower": false,
          "international_travel_allowed": false,
          "inverter": false,
          "kitchen_sink": false,
          "leveling_jacks": false,
          "microwave": false,
          "minimum_age": 0,
          "mpg": 0,
          "one_way_rentals": false,
          "outside_shower": false,
          "oven": false,
          "pet_friendly": false,
          "propane_tank": 0,
          "provides_receivers": false,
          "radio": false,
          "refrigerator": false,
          "satellite": false,
          "sewage_tank": 0,
          "skylight": false,
          "slide_outs": 1,
          "smoking_allowed": false,
          "solar": false,
          "stove": false,
          "tailgate_friendly": true,
          "toilet": false,
          "tow_hitch": false,
          "trailer_weight": 1200,
          "transmission": "",
          "tv_dvd": false,
          "washer_dryer": false,
          "water_tank": 11,
          "wifi": false
        },
        "first_published": "2020-03-12T16:29:59.112265-07:00",
        "generator_usage_item_id": 0,
        "group_on_map": true,
        "group_reviews_num": 0,
        "group_reviews_score": 0,
        "group_score": 0,
        "has_been_published": true,
        "has_checkout_questions": false,
        "hidden": false,
        "host_notes": "",
        "house_rules": "",
        "instant_book": false,
        "instant_book_leeway": 0,
        "insurance_coverage": "",
        "insurance_eligible": true,
        "insurance_plan": {
          "id": 96,
          "label": "Outdoorsy Drivable Protection",
          "renter_body": "",
          "renter_headline": "",
          "requires_driver_verification": false
        },
        "insurance_renter_adjustable": false,
        "insurance_state": "approved",
        "last_published": "2020-03-12T16:29:59.112222-07:00",
        "listing_questions": [],
        "locale": {
          "base_currency": "USD",
          "distance_unit": "miles",
          "length_unit": "feet",
          "liquid_unit": "gallons",
          "weight_unit": "lbs"
        },
        "location": {
          "city": "Sparta",
          "country": "US",
          "county": "",
          "lat": 41.031,
          "lng": -74.592,
          "state": "NJ",
          "street": "14 Angelo Dr",
          "zip": "07871"
        },
        "mileage_usage_item_id": 184960,
        "minimum_days": 0,
        "minimum_deposit": 0,
        "misc": null,
        "monthly_discount": 0,
        "name": "2014 7x12 cargo trailer",
        "nearby_content": [],
        "original_url": "",
        "owner_score": 0.5,
        "parent_id": 0,
        "position": 0,
        "preferred_primary_image": {
          "amenity": null,
          "best": false,
          "category": null,
          "description": "",
          "position": 0,
          "primary": false,
          "rental_id": 0,
          "review": null,
          "skip_enhance": false,
          "status": "",
          "tags": "",
          "url": "",
          "video": false
        },
        "prep_fee": {
          "amount": 0,
          "description": ""
        },
        "presentment_currency": "USD",
        "price_per_day": 7000,
        "price_per_month": 207900,
        "price_per_week": 42000,
        "primary_image_url": "https://res.cloudinary.com/outdoorsy/image/upload/v1584052166/p/rentals/159587/images/aspfh0uk5gutqfgmx8rb.jpg",
        "pro": false,
        "published": true,
        "ranking": {
          "distance_weight": {
            "control": 0.35,
            "test_1": 0.6,
            "test_2": 0.35,
            "test_3": 0.35
          },
          "distance_weight_prod": 0.35,
          "is_new_listing": 0,
          "model_name": "model_gbt_web_072522",
          "original_score": 0,
          "ranking_score": 0.3194,
          "ranking_score2": 0.44,
          "ranking_score3": 0.3194
        },
        "rental_category": "rv",
        "rental_score": 0.143,
        "request_less_than_minimum_days": 0,
        "review_scores": null,
        "reviews_num": 0,
        "score": 0,
        "seatbelts": 1,
        "security_deposit": 60000,
        "seo_content": {
          "category": [
            {
              "id": 202496,
              "title": "Tow Vehicle rental by location",
              "url": "https://www.outdoorsy.com/rv-makes-types/tow-vehicle-rental"
            },
            {
              "id": 210563,
              "title": "New Jersey Tow Vehicle rental",
              "url": "https://www.outdoorsy.com/rv-makes-types/tow-vehicle-rental/NJ"
            }
          ]
        },
        "settlement_currency": "USD",
        "sleeps": 1,
        "sleeps_adults": 0,
        "sleeps_kids": 0,
        "slug": "/rv-rental/sparta_nj/2014___159587-listing",
        "smart_photo_score": 0,
        "sort_score": 2.7390149,
        "stay": null,
        "stay_catalog": null,
        "summary": "",
        "tags": [],
        "tax_rates": [],
        "type": "tow-vehicle",
        "unavailable": false,
        "updated": "0001-01-01T00:00:00Z",
        "use_day_pricing": false,
        "use_tax_inclusive_pricing": false,
        "user_slug": "",
        "vehicle_amps": 0,
        "vehicle_box_length": 0,
        "vehicle_class": "",
        "vehicle_dry_weight": 1200,
        "vehicle_gvwr": 4200,
        "vehicle_height": 0,
        "vehicle_length": 12,
        "vehicle_length_with_hitch": 0,
        "vehicle_license_plate_state": "NJ",
        "vehicle_make": "CARRY-ON",
        "vehicle_model": "ENCLOSED TRAILER",
        "vehicle_title": "2014 CARRY-ON ENCLOSED TRAILER",
        "vehicle_width": 0,
        "vehicle_year": 2014,
        "weekly_discount": 0
      },
      "relationships": {
        "images": {
          "data": [
            {
              "id": "1256720",
              "type": "images"
            },
            {
              "id": "1256718",
              "type": "images"
            },
            {
              "id": "1256719",
              "type": "images"
            },
            {
              "id": "1256722",
              "type": "images"
            },
            {
              "id": "2137189",
              "type": "images"
            },
            {
              "id": "1256721",
              "type": "images"
            },
            {
              "id": "2137177",
              "type": "images"
            },
            {
              "id": "2137178",
              "type": "images"
            }
          ]
        },
        "mileage_usage_item": {
          "data": {
            "id": "184960",
            "type": "usage_based_item"
          }
        },
        "owner": {
          "data": {
            "id": "1115997",
            "type": "users"
          }
        },
        "primary_image": {
          "data": {
            "id": "1256720",
            "type": "images"
          }
        }
      }
    },
    {
      "id": "252891",
      "type": "rentals",
      "attributes": {
        "Explanation": null,
        "FeaturesMap": null,
        "active_options": {
          "cancel_policy": "flexible",
          "cancel_policy_combo_bookings": "",
          "date": "2024-02-09",
          "instant_book": true,
          "minimum_days": 2,
          "monthly_discount_percentage": 20,
          "monthly_rate_per_day": 9864,
          "price_per_day": 12330,
          "price_per_month": 276192,
          "price_per_week": 77679,
          "tax": 0,
          "use_day_pricing": false,
          "use_tax_inclusive_pricing": false,
          "weekly_discount_percentage": 10,
          "weekly_rate_per_day": 11097
        },
        "availability_set": false,
        "average_ratings": {
          "cleanliness_score": 0,
          "cleanliness_score_percentage": 0,
          "communication_score": 0,
          "communication_score_percentage": 0,
          "listing_score": 0,
          "listing_score_percentage": 0,
          "mechanical_score": 0,
          "mechanical_score_percentage": 0,
          "score": 0,
          "score_percentage": 0,
          "value_score": 0,
          "value_score_percentage": 0
        },
        "average_reviews": null,
        "campground": null,
        "campground_catalog": null,
        "campsite_category": null,
        "campsite_category_catalog": null,
        "cancel_policy": "flexible",
        "cancel_policy_combo_bookings": "",
        "cancel_text": "",
        "catalog": null,
        "check_in": 0,
        "check_out": 0,
        "children_count": 0,
        "coachnet_ready": true,
        "coachnet_required": false,
        "combined_special_hours": [],
        "created": "0001-01-01T00:00:00Z",
        "current_location_id": 0,
        "custom_insurance_text": "",
        "dealer": false,
        "delivery": false,
        "delivery_radius": 0,
        "delivery_usage_item_id": 307534,
        "deposit_percentage": 0,
        "description": "",
        "description_included": "Optional hospitality package-\nToiletries package \n2 towel sets (bath, hand and wash)\nLinens (one King size set OR 2 twin size sets)\nDishware for 2 \nCookware \nCoffee & Tea \n\nTrailer includes-\n13,500 Roof A/C\nAM/FM Stereo w/ Bluetooth and USB\n12 Volt TV w/ DVD Player\nRoller Shades\n20,000 BTU Furnace\nFold Out Entry Steps \nRoof Ladder \nMagnetic Baggage Door Catches\nOutside Shower\nTeton All In One Wi-Fi Booster/LTE Prep & Antenna\nOutside Griddle with LP Hookup\nOutside Speaker\n190 Watt Roof Mount Solar Panel w/ 1000 Watt Inverter\nPower Awning \nPolished Alloy Wheels\nTinted Bonded Frameless Windows\nHeated Holding Tanks",
        "description_other": "",
        "description_recommendations": "",
        "display_vehicle_type": "Travel trailer",
        "distributed_ratings": {
          "score": {
            "r1": 0,
            "r2": 0,
            "r3": 0,
            "r4": 0,
            "r5": 0
          }
        },
        "education": [],
        "external": false,
        "favorite": false,
        "favorite_count": 35,
        "features": {
          "air_conditioner": true,
          "audio_inputs": true,
          "awning": true,
          "backup_camera": false,
          "base_weight": 2014,
          "beds_bunk": null,
          "beds_dinette_conversion": null,
          "beds_fold_out_sofa": null,
          "beds_full": 0,
          "beds_king": 1,
          "beds_other": null,
          "beds_queen": 0,
          "beds_twin": 0,
          "bike_rack": false,
          "brake_controller": false,
          "burning_man_friendly": true,
          "carrying_capacity": 1208,
          "cd_player": true,
          "ceiling_fan": true,
          "connector_type": null,
          "dining_table": true,
          "extra_storage": true,
          "festival_friendly": true,
          "generator": true,
          "gray_tank": 12,
          "gross_vehicle_weight": 0,
          "handicap_accessible": false,
          "heater": true,
          "hitch_weight": 357,
          "hookup_electric": true,
          "hookup_sewer": true,
          "hookup_water": true,
          "hot_water_tank": false,
          "inside_shower": true,
          "international_travel_allowed": false,
          "inverter": false,
          "kitchen_sink": true,
          "leveling_jacks": true,
          "microwave": true,
          "minimum_age": 0,
          "mpg": 0,
          "one_way_rentals": false,
          "outside_shower": true,
          "oven": false,
          "pet_friendly": true,
          "propane_tank": 0,
          "provides_receivers": false,
          "radio": true,
          "refrigerator": true,
          "satellite": false,
          "sewage_tank": 12,
          "skylight": true,
          "slide_outs": 0,
          "smoking_allowed": false,
          "solar": false,
          "stove": true,
          "tailgate_friendly": false,
          "toilet": true,
          "tow_hitch": false,
          "trailer_weight": 2014,
          "tv_dvd": true,
          "washer_dryer": false,
          "water_tank": 31,
          "wifi": false
        },
        "first_published": "2021-08-06T12:23:43.322836-07:00",
        "generator_usage_item_id": 0,
        "group_on_map": false,
        "group_reviews_num": 0,
        "group_reviews_score": 0,
        "group_score": 0,
        "has_been_published": true,
        "has_checkout_questions": false,
        "hidden": false,
        "host_notes": "",
        "house_rules": "",
        "instant_book": true,
        "instant_book_leeway": 4,
        "insurance_coverage": "",
        "insurance_eligible": true,
        "insurance_plan": {
          "id": 97,
          "label": "Outdoorsy Towable Protection",
          "renter_body": "",
          "renter_headline": "",
          "requires_driver_verification": false
        },
        "insurance_renter_adjustable": false,
        "insurance_state": "approved",
        "last_published": "2021-08-06T12:23:43.322777-07:00",
        "listing_questions": [],
        "locale": {
          "base_currency": "USD",
          "distance_unit": "miles",
          "length_unit": "feet",
          "liquid_unit": "gallons",
          "weight_unit": "lbs"
        },
        "location": {
          "city": "New City",
          "country": "US",
          "county": "",
          "lat": 41.16,
          "lng": -74.031,
          "state": "NY",
          "street": "10 Park Ave",
          "zip": "10956"
        },
        "mileage_usage_item_id": 307474,
        "minimum_days": 0,
        "minimum_deposit": 0,
        "misc": null,
        "monthly_discount": 2000,
        "name": "One Happy Camper",
        "nearby_content": [],
        "original_url": "",
        "owner_score": 0,
        "parent_id": 0,
        "position": 0,
        "preferred_primary_image": {
          "amenity": null,
          "best": false,
          "category": null,
          "description": "",
          "position": 0,
          "primary": false,
          "rental_id": 0,
          "review": null,
          "skip_enhance": false,
          "status": "",
          "tags": "",
          "url": "",
          "video": false
        },
        "prep_fee": {
          "amount": 0,
          "description": ""
        },
        "presentment_currency": "USD",
        "price_per_day": 12330,
        "price_per_month": 299619,
        "price_per_week": 73980,
        "primary_image_url": "https://res.cloudinary.com/outdoorsy/image/upload/v1628266997/p/rentals/252891/images/kvgro9nezy1tjiaavxuc.jpg",
        "pro": false,
        "published": true,
        "ranking": {
          "distance_weight": {
            "control": 0.35,
            "test_1": 0.6,
            "test_2": 0.35,
            "test_3": 0.35
          },
          "distance_weight_prod": 0.35,
          "is_new_listing": 0,
          "model_name": "model_gbt_web_072522",
          "original_score": 0,
          "ranking_score": 0.2889,
          "ranking_score2": 0.5142,
          "ranking_score3": 0.2889
        },
        "rental_category": "rv",
        "rental_score": 0,
        "request_less_than_minimum_days": 0,
        "review_scores": null,
        "reviews_num": 0,
        "score": 0,
        "seatbelts": 0,
        "security_deposit": 50000,
        "seo_content": {
          "category": [
            {
              "id": 199680,
              "title": "Forest River RV rental by model",
              "url": "https://www.outdoorsy.com/rv-makes-types/forest-river-m"
            },
            {
              "id": 210165,
              "title": "Forest River Rockwood RV rental (6)",
              "url": "https://www.outdoorsy.com/rv-makes-types/forest-river-m/rockwood-6"
            },
            {
              "id": 201025,
              "title": "Forest River RV rental by year of production",
              "url": "https://www.outdoorsy.com/rv-makes-types/forest-river-y"
            },
            {
              "id": 210219,
              "title": "2020 Forest River RV rental (5)",
              "url": "https://www.outdoorsy.com/rv-makes-types/forest-river-y/2020-5"
            },
            {
              "id": 202488,
              "title": "Trailer rental by location",
              "url": "https://www.outdoorsy.com/rv-makes-types/trailer-rental"
            },
            {
              "id": 207883,
              "title": "New York Trailer rental (3)",
              "url": "https://www.outdoorsy.com/rv-makes-types/trailer-rental/NY-3"
            }
          ]
        },
        "settlement_currency": "USD",
        "sleeps": 2,
        "sleeps_adults": 0,
        "sleeps_kids": 0,
        "slug": "/rv-rental/new-city_ny/2018_forest-river_rockwood_252891-listing",
        "smart_photo_score": 0,
        "sort_score": 2.7337914,
        "stay": null,
        "stay_catalog": null,
        "summary": "",
        "tags": [],
        "tax_rates": [],
        "type": "trailer",
        "unavailable": false,
        "updated": "0001-01-01T00:00:00Z",
        "use_day_pricing": false,
        "use_tax_inclusive_pricing": false,
        "user_slug": "",
        "vehicle_amps": 0,
        "vehicle_box_length": 0,
        "vehicle_class": "",
        "vehicle_dry_weight": 2014,
        "vehicle_gvwr": 2667,
        "vehicle_height": 0,
        "vehicle_length": 16,
        "vehicle_length_with_hitch": 0,
        "vehicle_license_plate_state": "NY",
        "vehicle_make": "Forest River",
        "vehicle_model": "Rockwood",
        "vehicle_title": "2020 Forest River Rockwood",
        "vehicle_width": 0,
        "vehicle_year": 2020,
        "weekly_discount": 1000
      },
      "relationships": {
        "images": {
          "data": [
            {
              "id": "2049246",
              "type": "images"
            },
            {
              "id": "2049249",
              "type": "images"
            },
            {
              "id": "2049247",
              "type": "images"
            },
            {
              "id": "2049248",
              "type": "images"
            },
            {
              "id": "2049251",
              "type": "images"
            },
            {
              "id": "2050065",
              "type": "images"
            },
            {
              "id": "2050066",
              "type": "images"
            }
          ]
        },
        "mileage_usage_item": {
          "data": {
            "id": "307474",
            "type": "usage_based_item"
          }
        },
        "owner": {
          "data": {
            "id": "2354847",
            "type": "users"
          }
        },
        "primary_image": {
          "data": {
            "id": "2049246",
            "type": "images"
          }
        }
      }
    }
  ],
  "included": [
    {
      "id": "3006110",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": true,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083626/p/rentals/357873/images/o6bnrvbfykhsqz658yru.jpg",
        "video": false
      }
    },
    {
      "id": "3006108",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 2,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083627/p/rentals/357873/images/renx8glaxaota16p0ypv.jpg",
        "video": false
      }
    },
    {
      "id": "3006107",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 3,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083625/p/rentals/357873/images/odrx16ster7xjzawn69z.jpg",
        "video": false
      }
    },
    {
      "id": "3006109",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 4,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083625/p/rentals/357873/images/e1pswgfo8koyawyhxilv.jpg",
        "video": false
      }
    },
    {
      "id": "3006111",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 5,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083625/p/rentals/357873/images/yizw2xrbojt6iy6inhtj.jpg",
        "video": false
      }
    },
    {
      "id": "3006112",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 6,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083625/p/rentals/357873/images/deqwxgecbhdnqgrrhvim.jpg",
        "video": false
      }
    },
    {
      "id": "3006113",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 7,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083625/p/rentals/357873/images/pz7wbjtwkeqoix2ylf7h.jpg",
        "video": false
      }
    },
    {
      "id": "3006114",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 8,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083626/p/rentals/357873/images/ytjma6lk2w0ij8ru3xjf.jpg",
        "video": false
      }
    },
    {
      "id": "3006115",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 9,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083627/p/rentals/357873/images/uifmesnolh2pr2hdxw5a.jpg",
        "video": false
      }
    },
    {
      "id": "3006116",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 10,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1683083627/p/rentals/357873/images/yfncfoshbpe988oatgxi.jpg",
        "video": false
      }
    },
    {
      "id": "3043098",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 11,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1684622760/undefined/rentals/357873/images/gb8ujcghcmfcetgawavk.jpg",
        "video": false
      }
    },
    {
      "id": "3048506",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 12,
        "primary": false,
        "rental_id": 357873,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1684853287/undefined/rentals/357873/images/souqgyz253jcbjvurqhb.jpg",
        "video": false
      }
    },
    {
      "id": "2384793",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "exterior"
        },
        "description": "",
        "position": 1,
        "primary": true,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1648605383/p/rentals/286784/images/kqt64ccg1dtuijcskv7k.jpg",
        "video": false
      }
    },
    {
      "id": "2408278",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 2,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640028/p/rentals/286784/images/fhhnfuernp6gamdddzfs.jpg",
        "video": false
      }
    },
    {
      "id": "2408289",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 3,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640076/p/rentals/286784/images/zujcamcrdz0e0fngbupg.jpg",
        "video": false
      }
    },
    {
      "id": "2384804",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "exterior"
        },
        "description": "This is the moment we were driving the camper off the lot. Many large SUVs can pull this camper!",
        "position": 4,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1648605530/p/rentals/286784/images/mdsloofiuzampshuwuae.jpg",
        "video": false
      }
    },
    {
      "id": "2384794",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "exterior"
        },
        "description": "",
        "position": 5,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1648605385/p/rentals/286784/images/wt8r6q0rrlx2ejw7ebem.jpg",
        "video": false
      }
    },
    {
      "id": "2408332",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 6,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640765/p/rentals/286784/images/wdshozqw3hygvwgkpt3k.webp",
        "video": false
      }
    },
    {
      "id": "2408277",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 7,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640035/p/rentals/286784/images/ixvyr33xf9q9lgstgpua.jpg",
        "video": false
      }
    },
    {
      "id": "2408279",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 8,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640029/p/rentals/286784/images/xmfqwnl0fgjhojmv34cu.jpg",
        "video": false
      }
    },
    {
      "id": "2408312",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 9,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640600/p/rentals/286784/images/ibhnfkf7qtv5qd6ip3zt.jpg",
        "video": false
      }
    },
    {
      "id": "2408311",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 10,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "pending",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640601/p/rentals/286784/images/g61wphwguq0eohzycd9t.jpg",
        "video": false
      }
    },
    {
      "id": "2408285",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 11,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640062/p/rentals/286784/images/fpcblfkmvspqq6hzt11f.jpg",
        "video": false
      }
    },
    {
      "id": "2408283",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 12,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640040/p/rentals/286784/images/mrkv1x3hjxjvdgobrl3d.jpg",
        "video": false
      }
    },
    {
      "id": "2408282",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 13,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640048/p/rentals/286784/images/tecg84yqfhvzmrsgnp6s.jpg",
        "video": false
      }
    },
    {
      "id": "2408293",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 14,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640087/p/rentals/286784/images/gwdv5erfupol9l1z6chw.jpg",
        "video": false
      }
    },
    {
      "id": "2408291",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 15,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640073/p/rentals/286784/images/dtlwho0tnbmfx6tvrpwo.jpg",
        "video": false
      }
    },
    {
      "id": "2408286",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 16,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640048/p/rentals/286784/images/rppkxxijtrbkwxvz0o5o.jpg",
        "video": false
      }
    },
    {
      "id": "2408307",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 17,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640597/p/rentals/286784/images/cqehydw9ki3oj9ofczob.jpg",
        "video": false
      }
    },
    {
      "id": "2408295",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 18,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640091/p/rentals/286784/images/opss25nucrpakeqpytq6.jpg",
        "video": false
      }
    },
    {
      "id": "2408284",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 19,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640051/p/rentals/286784/images/gzyecvbhl9ivhxh3ih9o.jpg",
        "video": false
      }
    },
    {
      "id": "2408318",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 20,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640613/p/rentals/286784/images/xpuukcijhudmveclso9z.jpg",
        "video": false
      }
    },
    {
      "id": "2408317",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 21,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640605/p/rentals/286784/images/iluaug2dcbp5kej9sx8h.jpg",
        "video": false
      }
    },
    {
      "id": "2408316",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 22,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640610/p/rentals/286784/images/yjxddp0ec6p2hymxdkwl.jpg",
        "video": false
      }
    },
    {
      "id": "2408315",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 23,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640614/p/rentals/286784/images/amvzggahv0uzadfl01ua.jpg",
        "video": false
      }
    },
    {
      "id": "2408308",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 24,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640599/p/rentals/286784/images/c1cfxey2gaedqubftpf6.jpg",
        "video": false
      }
    },
    {
      "id": "2408309",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 25,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640596/p/rentals/286784/images/owky1xtp1ez2mnwlqjcn.jpg",
        "video": false
      }
    },
    {
      "id": "2408310",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 26,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640597/p/rentals/286784/images/wlbu0gxfau4cafcoiclq.jpg",
        "video": false
      }
    },
    {
      "id": "2408313",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 27,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640603/p/rentals/286784/images/akgvgnm1wznsstschgvk.jpg",
        "video": false
      }
    },
    {
      "id": "2408314",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 28,
        "primary": false,
        "rental_id": 286784,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1649640608/p/rentals/286784/images/w9p7pyqcnv5fr6ia1ucp.jpg",
        "video": false
      }
    },
    {
      "id": "3244499",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": true,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694469620/p/rentals/384054/images/xrkwyplzdalexmtnsvcs.jpg",
        "video": false
      }
    },
    {
      "id": "3244501",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 2,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694469620/p/rentals/384054/images/iy7f9x8su03b7kmgrfsv.jpg",
        "video": false
      }
    },
    {
      "id": "3244498",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 3,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694469618/p/rentals/384054/images/w0jdjejsboizqpsqna5g.jpg",
        "video": false
      }
    },
    {
      "id": "3244500",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 4,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694469619/p/rentals/384054/images/odlfgjrwusop2dx03met.jpg",
        "video": false
      }
    },
    {
      "id": "3244503",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 5,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694469618/p/rentals/384054/images/dgnvsfx3heojfrlsjyde.jpg",
        "video": false
      }
    },
    {
      "id": "3244504",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 6,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694470379/p/rentals/384054/images/lp4u3iypefzs2mwdzq3n.jpg",
        "video": false
      }
    },
    {
      "id": "3244505",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 7,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694470379/p/rentals/384054/images/p9uajjsfe7xypj7q4xkl.jpg",
        "video": false
      }
    },
    {
      "id": "3244506",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 8,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694470378/p/rentals/384054/images/h6titk63ef0pfqmnkmbg.jpg",
        "video": false
      }
    },
    {
      "id": "3244507",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 9,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694470379/p/rentals/384054/images/vsbnnrx2kjyiv2v2fma9.jpg",
        "video": false
      }
    },
    {
      "id": "3244508",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 10,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694470379/p/rentals/384054/images/jsz2wmhjaenoxxjkkams.jpg",
        "video": false
      }
    },
    {
      "id": "3244509",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 11,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694470379/p/rentals/384054/images/azl4nc4lwqqu1lnlx4du.jpg",
        "video": false
      }
    },
    {
      "id": "3244510",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 12,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694470381/p/rentals/384054/images/xqcvmo82ne3bayugfs7f.jpg",
        "video": false
      }
    },
    {
      "id": "3244511",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 13,
        "primary": false,
        "rental_id": 384054,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1694470380/p/rentals/384054/images/q0k8z2bmqmcuxidthzxl.jpg",
        "video": false
      }
    },
    {
      "id": "2902488",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": true,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528082/p/rentals/347204/images/tcx1cmdhd1rgeabtwctk.jpg",
        "video": false
      }
    },
    {
      "id": "2902497",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 2,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528389/p/rentals/347204/images/jpi1m2oub8x1jy93yatt.jpg",
        "video": false
      }
    },
    {
      "id": "2902499",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 3,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "rejected",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528393/p/rentals/347204/images/ncesogausb9cwzcmfotl.jpg",
        "video": false
      }
    },
    {
      "id": "2902500",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 4,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528401/p/rentals/347204/images/rd08lpb5ewcabyspsl9y.jpg",
        "video": false
      }
    },
    {
      "id": "2902501",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 5,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528550/p/rentals/347204/images/tq0zyt5mflsaqsduep2g.jpg",
        "video": false
      }
    },
    {
      "id": "2902505",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 6,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528571/p/rentals/347204/images/e5nfe8xcfpju5jajifzm.jpg",
        "video": false
      }
    },
    {
      "id": "2902506",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 7,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528582/p/rentals/347204/images/cueqmt3udroij5kk3ndo.jpg",
        "video": false
      }
    },
    {
      "id": "2902503",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 8,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528558/p/rentals/347204/images/db8dxltimpk4kwcxhjdv.jpg",
        "video": false
      }
    },
    {
      "id": "2902502",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 9,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528554/p/rentals/347204/images/i8n5t58vur4wje2mf3so.jpg",
        "video": false
      }
    },
    {
      "id": "2902507",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 10,
        "primary": false,
        "rental_id": 347204,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1677528671/p/rentals/347204/images/ply3rwgxswbixqriqscg.jpg",
        "video": false
      }
    },
    {
      "id": "2203269",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": true,
        "rental_id": 269643,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1636660753/undefined/rentals/269643/images/oulcqox9zo52ovbojttb.jpg",
        "video": false
      }
    },
    {
      "id": "2203270",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 2,
        "primary": false,
        "rental_id": 269643,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1636660760/undefined/rentals/269643/images/r4v8ystdhvseqgmmfldv.jpg",
        "video": false
      }
    },
    {
      "id": "2203271",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 3,
        "primary": false,
        "rental_id": 269643,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1636660768/undefined/rentals/269643/images/zsl8pwekwb5gnxwvnhyg.jpg",
        "video": false
      }
    },
    {
      "id": "2203272",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 4,
        "primary": false,
        "rental_id": 269643,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1636660776/undefined/rentals/269643/images/kwqvogyq22li8a6p4gdv.jpg",
        "video": false
      }
    },
    {
      "id": "3117669",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": true,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797072/undefined/rentals/369764/images/ahdswxkqtsipn4uo99jn.jpg",
        "video": false
      }
    },
    {
      "id": "3117670",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 2,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797074/undefined/rentals/369764/images/n0lebwgnyj0jhk5vajk5.jpg",
        "video": false
      }
    },
    {
      "id": "3117671",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 3,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797076/undefined/rentals/369764/images/mamrjmh75wg4bn4njpiy.jpg",
        "video": false
      }
    },
    {
      "id": "3117672",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 4,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797077/undefined/rentals/369764/images/l9ymxbbby8ljfeo8zdud.jpg",
        "video": false
      }
    },
    {
      "id": "3117673",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 5,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797079/undefined/rentals/369764/images/uvpz61caejqaq6pyf9ul.jpg",
        "video": false
      }
    },
    {
      "id": "3117674",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 6,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797081/undefined/rentals/369764/images/tn2vfixlw0bnq6ureu2k.jpg",
        "video": false
      }
    },
    {
      "id": "3117675",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 7,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797083/undefined/rentals/369764/images/m78zsbur7xvsaepegr8f.jpg",
        "video": false
      }
    },
    {
      "id": "3117676",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 8,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797084/undefined/rentals/369764/images/anunwmfgdhhegldwxhoz.jpg",
        "video": false
      }
    },
    {
      "id": "3117677",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 9,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797087/undefined/rentals/369764/images/s9nkv4zqvgqynwqag1oe.jpg",
        "video": false
      }
    },
    {
      "id": "3117678",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 10,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797088/undefined/rentals/369764/images/nzlgxxpz8btc4c9ku30v.jpg",
        "video": false
      }
    },
    {
      "id": "3117679",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 11,
        "primary": false,
        "rental_id": 369764,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1687797090/undefined/rentals/369764/images/bomixkj9pvchm8tuoaoc.jpg",
        "video": false
      }
    },
    {
      "id": "1256720",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": true,
        "rental_id": 159587,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1584052166/p/rentals/159587/images/aspfh0uk5gutqfgmx8rb.jpg",
        "video": false
      }
    },
    {
      "id": "1256718",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": false,
        "rental_id": 159587,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1631889568/p/rentals/159587/images/ousj5ap65jfpxy9hbmja.jpg",
        "video": false
      }
    },
    {
      "id": "1256719",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": false,
        "rental_id": 159587,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1584052145/p/rentals/159587/images/riw3i7yc987x9njkfajo.jpg",
        "video": false
      }
    },
    {
      "id": "1256722",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": false,
        "rental_id": 159587,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1584052179/p/rentals/159587/images/pmbjg9yvejsnf66ydg1w.jpg",
        "video": false
      }
    },
    {
      "id": "2137189",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": false,
        "rental_id": 159587,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1631889774/p/rentals/159587/images/gkcohxx3ibl6tyhw3qoy.jpg",
        "video": false
      }
    },
    {
      "id": "1256721",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": false,
        "rental_id": 159587,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1584052245/p/rentals/159587/images/abyeitprbepstumdqxmn.jpg",
        "video": false
      }
    },
    {
      "id": "2137177",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": false,
        "rental_id": 159587,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1631889727/p/rentals/159587/images/ybwdjgroqtrtr2hdxf3u.jpg",
        "video": false
      }
    },
    {
      "id": "2137178",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": false,
        "rental_id": 159587,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1631889763/p/rentals/159587/images/zrys2wl9pdxqnlwe57zn.jpg",
        "video": false
      }
    },
    {
      "id": "2049246",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 1,
        "primary": true,
        "rental_id": 252891,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1628266997/p/rentals/252891/images/kvgro9nezy1tjiaavxuc.jpg",
        "video": false
      }
    },
    {
      "id": "2049249",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 2,
        "primary": false,
        "rental_id": 252891,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1628266999/p/rentals/252891/images/tgpozsj6wgbomndocm6s.jpg",
        "video": false
      }
    },
    {
      "id": "2049247",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 3,
        "primary": false,
        "rental_id": 252891,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1628266997/p/rentals/252891/images/unpcvjhz9qht4j30npf4.jpg",
        "video": false
      }
    },
    {
      "id": "2049248",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 4,
        "primary": false,
        "rental_id": 252891,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1628266997/p/rentals/252891/images/md8xjjl8fswrw6ohlnvo.jpg",
        "video": false
      }
    },
    {
      "id": "2049251",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 5,
        "primary": false,
        "rental_id": 252891,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1628266999/p/rentals/252891/images/ub2njetv04s8lv0l4nrt.jpg",
        "video": false
      }
    },
    {
      "id": "2050065",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 6,
        "primary": false,
        "rental_id": 252891,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1628289002/undefined/rentals/252891/images/rpsurvxml0jiys4yrjxg.jpg",
        "video": false
      }
    },
    {
      "id": "2050066",
      "type": "images",
      "attributes": {
        "amenity": null,
        "best": false,
        "category": {
          "name": "",
          "slug": "other"
        },
        "description": "",
        "position": 7,
        "primary": false,
        "rental_id": 252891,
        "review": null,
        "skip_enhance": false,
        "status": "approved",
        "tags": "",
        "url": "https://res.cloudinary.com/outdoorsy/image/upload/v1628289015/undefined/rentals/252891/images/pg1aibqjlbyno7cjegse.jpg",
        "video": false
      }
    }
  ],
  "meta": {
    "radius": 100,
    "lat": 40.793,
    "lng": -74.0247,
    "city": "North Bergen",
    "state": "NJ",
    "country": "US",
    "country_code": "US",
    "country_name": "United States",
    "total": 184,
    "total_unavailable": 0,
    "start_position": 9,
    "stop_position": 16,
    "price_max": 40000,
    "price_min": 5000,
    "price_average": 13714,
    "price_median": 13000,
    "price_histogram": {
      "data": [
        0,
        0,
        18,
        14,
        31,
        65,
        25,
        13,
        5,
        5,
        3,
        2,
        1,
        0,
        1,
        0,
        1,
        0,
        0,
        0,
        0
      ],
      "max_value": 50000
    },
    "vehicle_types": [
      {
        "type": "fifth-wheel",
        "label": "Fifth-wheel",
        "style": "towable"
      },
      {
        "type": "other",
        "label": "Other",
        "style": "both"
      },
      {
        "type": "tow-vehicle",
        "label": "Tow Vehicle",
        "style": "drivable"
      },
      {
        "type": "trailer",
        "label": "Travel trailer",
        "style": "towable"
      },
      {
        "type": "truck-camper",
        "label": "Truck Camper",
        "style": "drivable"
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
        "type": "toy-hauler",
        "label": "Toy hauler",
        "style": "towable"
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
    }
}